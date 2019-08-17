package com.bzh.springcloud.weather.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.bzh.springcloud.weather.pojo.WeatherResponse;
import com.bzh.springcloud.weather.utils.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

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
		// ���������׳��쳣
		else {
			throw new RuntimeException("data not exixt in redis!");
		}

		// ͨ��fastjson���߽�jsonת����ʵ����
		try {
			response = mapper.readValue(jsonString, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}
}
