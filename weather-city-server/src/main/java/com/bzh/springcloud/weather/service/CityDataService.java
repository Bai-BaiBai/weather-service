package com.bzh.springcloud.weather.service;

import java.util.List;

import com.bzh.springcloud.weather.pojo.City;

/**
 * 城市数据服务
 * @ClassName: CityDataService
 * @author BaiZehong
 * @date 2019年8月13日
 * @since JDK 1.8
 */
public interface CityDataService {

	/**
	 * 获取城市列表
	 * @Title: listCity
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
