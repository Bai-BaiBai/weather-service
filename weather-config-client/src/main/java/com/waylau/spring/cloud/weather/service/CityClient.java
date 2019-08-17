package com.waylau.spring.cloud.weather.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * City Client
 * @ClassName: CityClient
 * @author BaiZehong
 * @date 2019��8��15��
 * @since JDK 1.8
 */
@FeignClient("service-name")// ָ������ĵ�ַ
public interface CityClient {

	@GetMapping("/cities")//ָ������ľ���λ��
	String listCity();
}
