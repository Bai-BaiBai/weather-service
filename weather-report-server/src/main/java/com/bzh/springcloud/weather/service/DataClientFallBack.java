package com.bzh.springcloud.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * ��·����Чʱ����ص������ж�Ӧ�ķ���
 * @ClassName: DataClientFallBack
 * @author BaiZehong
 * @date 2019��8��16��
 * @since JDK 1.8
 */
@Component
public class DataClientFallBack implements DataClient {

	/**
	 * �������ʧ�ܣ��򷵻ع̶��ĳ����б�
	 */
	@Override
	public List<City> listCity() throws Exception {
		
		List<City> cityList = null;
		cityList = new ArrayList<>();
		
		City city = new City();
		city.setCityId("101280601");
		city.setCityName("����");
		cityList.add(city);
		
		return cityList;
	}

	@Override
	public WeatherResponse getWeatherDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
