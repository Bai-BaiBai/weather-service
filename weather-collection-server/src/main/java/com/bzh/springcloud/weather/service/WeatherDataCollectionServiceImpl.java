package com.bzh.springcloud.weather.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bzh.springcloud.weather.utils.Constant;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

	private static final long TIMEOUT = 3;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
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
