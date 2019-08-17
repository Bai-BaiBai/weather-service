package com.bzh.springcloud.weather.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * 	API���ػὫ����ת������Ӧ����
 * @ClassName: DataClient
 * @author BaiZehong
 * @date 2019��8��16��
 * @since JDK 1.8
 */
@FeignClient(name="weather-eureka-zuul", fallback=DataClientFallBack.class)
public interface DataClient {

	/**
	 * 	��ȡ�����б�API���ػὫ����ת������Ӧ����
	 * @Title: listCity
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
	
	/**
	 * 	������ID��ȡ������Ϣ
	 * @Title: getWeatherDataByCityId
	 * @param cityId
	 * @return
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getWeatherDataByCityId(@PathVariable("cityId") String cityId);
}
