package com.bzh.springcloud.weather.service;

/**
 * Weather Data Collection Service
 * @ClassName: WeatherDataCollectionService
 * @author BaiZehong
 * @date 2019年8月14日
 * @since JDK 1.8
 */
public interface WeatherDataCollectionService {

	/**
	 * 根据城市id同步天气数据
	 * @Title: syncDataByCityId
	 * @param cityId
	 */
	void syncDataByCityId(String cityId);
}
