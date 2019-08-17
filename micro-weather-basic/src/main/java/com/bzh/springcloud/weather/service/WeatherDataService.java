package com.bzh.springcloud.weather.service;

import com.bzh.springcloud.weather.pojo.WeatherResponse;

/**
 * �������ݽӿ�
 * @ClassName: WeatherDataService
 * @Description: �������ݽӿ�
 * @author BaiZehong
 * @date 2019��8��12��
 * @since JDK 1.8
 */
public interface WeatherDataService {

	/**
	 * ���ݳ���id��ѯ����
	 * @Title: getDataByCityId
	 * @Description: ���ݳ���id��ѯ����
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	
	/**
	 * ���ݳ������Ʋ�ѯ����
	 * @Title: getDataByCityName
	 * @Description: ���ݳ������Ʋ�ѯ����
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
	
	/**
	 * ���ݳ���idͬ����Ϣ
	 * @Title: syncDataByCityId
	 * @param cityId
	 */
	void syncDataByCityId(String cityId);
}
