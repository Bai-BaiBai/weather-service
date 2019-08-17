package com.bzh.springcloud.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * 断路器生效时，会回调此类中对应的方法
 * @ClassName: DataClientFallBack
 * @author BaiZehong
 * @date 2019年8月16日
 * @since JDK 1.8
 */
@Component
public class DataClientFallBack implements DataClient {

	/**
	 * 如果调用失败，则返回固定的城市列表
	 */
	@Override
	public List<City> listCity() throws Exception {
		
		List<City> cityList = null;
		cityList = new ArrayList<>();
		
		City city = new City();
		city.setCityId("101280601");
		city.setCityName("深圳");
		cityList.add(city);
		
		return cityList;
	}

	@Override
	public WeatherResponse getWeatherDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
