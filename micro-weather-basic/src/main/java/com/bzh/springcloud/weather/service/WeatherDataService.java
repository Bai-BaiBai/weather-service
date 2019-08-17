package com.bzh.springcloud.weather.service;

import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * 天气数据接口
 * @ClassName: WeatherDataService
 * @Description: 天气数据接口
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */
public interface WeatherDataService {

	/**
	 * 根据城市id查询天气
	 * @Title: getDataByCityId
	 * @Description: 根据城市id查询天气
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	
	/**
	 * 根据城市名称查询天气
	 * @Title: getDataByCityName
	 * @Description: 根据城市名称查询天气
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
	
	/**
	 * 根据城市id同步信息
	 * @Title: syncDataByCityId
	 * @param cityId
	 */
	void syncDataByCityId(String cityId);
}
