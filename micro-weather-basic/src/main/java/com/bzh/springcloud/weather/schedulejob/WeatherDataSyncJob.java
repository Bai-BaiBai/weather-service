package com.bzh.springcloud.weather.schedulejob;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.service.CityDataService;
import com.bzh.springcloud.weather.service.WeatherDataService;

/**
 * ��ʱ����redis�е���������
 * @ClassName: WeatherDataSyncJob
 * @author BaiZehong
 * @date 2019��8��12��
 * @since JDK 1.8
 */
public class WeatherDataSyncJob extends QuartzJobBean{

	@Autowired
	private CityDataService cityDataService;
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		// ��ȡ�����б�
		List<City> cityList = null;
		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ��������idͬ��������Ϣ
		if (cityList != null) {
			for (City city : cityList) {
				weatherDataService.syncDataByCityId(city.getCityId());
			}
		}
	}

}
