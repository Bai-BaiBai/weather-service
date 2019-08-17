package com.bzh.springcloud.weather.schedulejob;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.service.CityClient;
import com.bzh.springcloud.weather.service.WeatherDataCollectionService;

/**
 * 定时更新redis中的天气数据
 * @ClassName: WeatherDataSyncJob
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */
public class WeatherDataSyncJob extends QuartzJobBean{
	
	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	
	@Autowired
	private CityClient cityClient;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		// 获取城市列表
		List<City> cityList = null;
		try {
			cityList = cityClient.listCity();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 遍历城市id同步天气信息
		if (cityList != null) {
			for (City city : cityList) {
				weatherDataCollectionService.syncDataByCityId(city.getCityId());
			}
		}
	}

}
