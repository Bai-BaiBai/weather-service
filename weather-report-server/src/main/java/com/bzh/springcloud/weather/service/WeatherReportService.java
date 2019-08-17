package com.bzh.springcloud.weather.service;

import com.bzh.springcloud.weather.pojo.Weather;

/**
 * 天气数据接口
 * @ClassName: WeatherReportService
 * @author BaiZehong
 * @date 2019年8月13日
 * @since JDK 1.8
 */
public interface WeatherReportService {

	/**
	 * 根据城市id查询天气信息
	 * @Title: getDataByCityId
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
