package com.bzh.springcloud.weather.service;

import com.bzh.springcloud.weather.pojo.Weather;

/**
 * �������ݽӿ�
 * @ClassName: WeatherReportService
 * @author BaiZehong
 * @date 2019��8��13��
 * @since JDK 1.8
 */
public interface WeatherReportService {

	/**
	 * ���ݳ���id��ѯ������Ϣ
	 * @Title: getDataByCityId
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
