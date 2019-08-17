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
		// 不存在则抛出异常
		else {
			throw new RuntimeException("data not exixt in redis!");
		}

		// 通过fastjson工具将json转换成实体类
		try {
			response = mapper.readValue(jsonString, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}
}
