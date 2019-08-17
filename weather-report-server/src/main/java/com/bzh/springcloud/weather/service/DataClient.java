package com.bzh.springcloud.weather.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * 	API网关会将请求转发到对应服务
 * @ClassName: DataClient
 * @author BaiZehong
 * @date 2019年8月16日
 * @since JDK 1.8
 */
@FeignClient(name="weather-eureka-zuul", fallback=DataClientFallBack.class)
public interface DataClient {

	/**
	 * 	获取城市列表，API网关会将请求转发到对应服务
	 * @Title: listCity
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
	
	/**
	 * 	按城市ID获取天气信息
	 * @Title: getWeatherDataByCityId
	 * @param cityId
	 * @return
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId);
}
