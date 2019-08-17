package com.waylau.spring.cloud.weather.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * City Client
 * @ClassName: CityClient
 * @author BaiZehong
 * @date 2019年8月15日
 * @since JDK 1.8
 */
@FeignClient("service-name")// 指明服务的地址
public interface CityClient {

	@GetMapping("/cities")//指明服务的具体位置
	String listCity();
}
