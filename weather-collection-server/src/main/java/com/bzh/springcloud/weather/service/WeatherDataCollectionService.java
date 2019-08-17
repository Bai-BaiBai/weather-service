package com.bzh.springcloud.weather.service;

/**
 * Weather Data Collection Service
 * @ClassName: WeatherDataCollectionService
 * @author BaiZehong
 * @date 2019��8��14��
 * @since JDK 1.8
 */
public interface WeatherDataCollectionService {

	/**
	 * ���ݳ���idͬ����������
	 * @Title: syncDataByCityId
	 * @param cityId
	 */
	void syncDataByCityId(String cityId);
}
