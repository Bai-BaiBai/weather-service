package com.bzh.springcloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzh.springcloud.weather.pojo.Weather;
import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * Weather Report Service Implement
 * @ClassName: WeatherReportServiceImpl
 * @author BaiZehong
 * @date 2019Äê8ÔÂ13ÈÕ
 * @since JDK 1.8
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
	
		WeatherResponse response = weatherDataService.getDataByCityId(cityId);
		
		return response.getData();
	}

}
