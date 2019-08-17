package com.bzh.springcloud.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzh.springcloud.weather.pojo.Weather;
import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * Weather Report Service Implement
 * @ClassName: WeatherReportServiceImpl
 * @author BaiZehong
 * @date 2019��8��13��
 * @since JDK 1.8
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	
	@Autowired
	private DataClient dataClient;

	@Override
	public Weather getDataByCityId(String cityId) {
		
		// ������������΢�����ȡ��������
		WeatherResponse response = dataClient.getWeatherDataByCityId(cityId);
		return response == null ? null : response.getData();
	}

}
