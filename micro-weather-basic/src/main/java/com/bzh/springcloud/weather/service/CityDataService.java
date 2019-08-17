package com.bzh.springcloud.weather.service;

import java.util.List;

import com.bzh.springcloud.weather.pojo.City;

/**
 * �������ݷ���
 * @ClassName: CityDataService
 * @author BaiZehong
 * @date 2019��8��13��
 * @since JDK 1.8
 */
public interface CityDataService {

	/**
	 * ��ȡ�����б�
	 * @Title: listCity
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
