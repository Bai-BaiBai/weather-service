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
	 * 重构出的获取天气数据方法
	 * 
	 * @Title: doGetWeather
	 * @param uri：获取天气数据的接口
	 * @return
	 */
	private WeatherResponse doGetWeather(String uri) {

		String key = uri;// uri作为Redis中的Key
		WeatherResponse response = null;// 天气信息Pojo类
		String jsonString = null;// 从Redis中 或 第三方接口中获取的天气数据json字符串
		ObjectMapper mapper = new ObjectMapper();// fastJson将json转换为实体类
		ValueOperations<String, String> values = stringRedisTemplate.opsForValue();

		// 如果redis缓存中存在，则使用缓存中数据
		if (stringRedisTemplate.hasKey(key)) {

			jsonString = values.get(key);
		}
		// 不存在则调用接口查询
		else {

			// 通过uri获取天气数据json
			ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
			if (entity.getStatusCodeValue() == 200) {

				jsonString = entity.getBody();
			}
			// 将数据写入缓存, 设置3小时超时
			values.set(key, jsonString, TIMEOUT, TimeUnit.HOURS);
		}

		// 通过fastjson工具将json转换成实体类
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
	 * 获取的天气数据并保存在Redis缓存中
	 * 
	 * @Title: saveWeatherData
	 * @param uri
	 */
	private void saveWeatherData(String uri) {

		String key = uri;
		String jsonString = null;
		ValueOperations<String, String> values = stringRedisTemplate.opsForValue();

		// 通过uri获取天气数据json
		ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
		if (entity.getStatusCodeValue() == 200) {

			jsonString = entity.getBody();
		}
		// 将数据写入缓存, 设置3小时超时
		values.set(key, jsonString, TIMEOUT, TimeUnit.HOURS);
	}
}
