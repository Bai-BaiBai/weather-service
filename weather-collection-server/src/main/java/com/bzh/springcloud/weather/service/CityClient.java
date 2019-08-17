package com.bzh.springcloud.weather.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bzh.springcloud.weather.pojo.City;

/**
 * ʹ��Feign ���ó����б�΢����
 * @ClassName: CityClient
 * @author BaiZehong
 * @date 2019��8��15��
 * @since JDK 1.8
 */
@FeignClient("weather-city-server")
public interface CityClient {

	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
