package com.bzh.springcloud.weather.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bzh.springcloud.weather.schedulejob.WeatherDataSyncJob;

/**
 * Quartz Configuration
 * @ClassName: QuartzConfiguation
 * @author BaiZehong
 * @date 2019��8��12��
 * @since JDK 1.8
 */

@Configuration
public class QuartzConfiguration {

	@Bean
	public JobDetail weatherDataSyncJobJobDetail() {
		// ʹ��JobBuilder����ȡ������ʱ���񴴽�����������Ϊ ��weatherDataSyncJob��
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
	}
	
	@Bean
	public Trigger weatherDataSyncTrigger() {
		
		// ���ö�ʱ����30����ִ��һ��,�����ڼ�һֱ�ظ�
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
																	.withIntervalInMinutes(30).repeatForever();
		
		// ������ �ֱ����ô���������(weatherDataSyncJob)�������ƻ�(schedBuilder)������������(weatherDataSyncTrigger)
		return TriggerBuilder.newTrigger()
							.forJob(weatherDataSyncJobJobDetail())
							.withIdentity("weatherDataSyncTrigger")
							.withSchedule(schedBuilder)
							.build();
	}
}
