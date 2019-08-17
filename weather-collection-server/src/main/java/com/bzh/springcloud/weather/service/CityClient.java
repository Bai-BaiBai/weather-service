package com.bzh.springcloud.weather.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bzh.springcloud.weather.pojo.City;

/**
 * 使用Feign 调用城市列表微服务
 * @ClassName: CityClient
 * @author BaiZehong
 * @date 2019年8月15日
 * @since JDK 1.8
 */
@FeignClient("weather-city-server")
public interface CityClient {

	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
