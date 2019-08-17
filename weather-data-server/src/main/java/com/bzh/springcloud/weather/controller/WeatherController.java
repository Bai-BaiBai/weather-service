package com.bzh.springcloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bzh.springcloud.weather.pojo.WeatherResponse;
import com.bzh.springcloud.weather.service.WeatherDataService;

/**
 * 天气控制器
 * @ClassName: WeatherController
 * @Description: 天气控制器
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
		
		return weatherDataService.getDataByCityId(cityId);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
		
		return weatherDataService.getDataByCityName(cityName);
	}
}
