package com.bzh.springcloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzh.springcloud.weather.pojo.Weather;
import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * Weather Report Service Implement
 * @ClassName: WeatherReportServiceImpl
 * @author BaiZehong
 * @date 2019年8月13日
 * @since JDK 1.8
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	
	@Autowired
	private DataClient dataClient;

	@Override
	public Weather getDataByCityId(String cityId) {
		
		// 调用天气数据微服务获取天气数据
		WeatherResponse response = dataClient.getWeatherDataByCityId(cityId);
		return response == null ? null : response.getData();
	}

}
