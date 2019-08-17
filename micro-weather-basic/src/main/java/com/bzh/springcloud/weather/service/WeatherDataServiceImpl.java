package com.bzh.springcloud.weather.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bzh.springcloud.weather.pojo.WeatherResponse;
import com.bzh.springcloud.weather.utils.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	private static final long TIMEOUT = 3;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public WeatherResponse getDataByCityId(String cityId) {

		String uri = Constant.WEATHER_DATA_URI + "citykey=" + cityId;
		return this.doGetWeather(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {

		String uri = Constant.WEATHER_DATA_URI + "city=" + cityName;
		return this.doGetWeather(uri);
	}

	/**
	 * �ع����Ļ�ȡ�������ݷ���
	 * 
	 * @Title: doGetWeather
	 * @param uri����ȡ�������ݵĽӿ�
	 * @return
	 */
	private WeatherResponse doGetWeather(String uri) {

		String key = uri;// uri��ΪRedis�е�Key
		WeatherResponse response = null;// ������ϢPojo��
		String jsonString = null;// ��Redis�� �� �������ӿ��л�ȡ����������json�ַ���
		ObjectMapper mapper = new ObjectMapper();// fastJson��jsonת��Ϊʵ����
		ValueOperations<String, String> values = stringRedisTemplate.opsForValue();

		// ���redis�����д��ڣ���ʹ�û���������
		if (stringRedisTemplate.hasKey(key)) {

			jsonString = values.get(key);
		}
		// ����������ýӿڲ�ѯ
		else {

			// ͨ��uri��ȡ��������json
			ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
			if (entity.getStatusCodeValue() == 200) {

				jsonString = entity.getBody();
			}
			// ������д�뻺��, ����3Сʱ��ʱ
			values.set(key, jsonString, TIMEOUT, TimeUnit.HOURS);
		}

		// ͨ��fastjson���߽�jsonת����ʵ����
		try {
			response = mapper.readValue(jsonString, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public void syncDataByCityId(String cityId) {

		String uri = Constant.WEATHER_DATA_URI + "citykey=" + cityId;
		this.saveWeatherData(uri);
	}

	/**
	 * ��ȡ���������ݲ�������Redis������
	 * 
	 * @Title: saveWeatherData
	 * @param uri
	 */
	private void saveWeatherData(String uri) {

		String key = uri;
		String jsonString = null;
		ValueOperations<String, String> values = stringRedisTemplate.opsForValue();

		// ͨ��uri��ȡ��������json
		ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
		if (entity.getStatusCodeValue() == 200) {

			jsonString = entity.getBody();
		}
		// ������д�뻺��, ����3Сʱ��ʱ
		values.set(key, jsonString, TIMEOUT, TimeUnit.HOURS);
	}
}
