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
 * @date 2019年8月12日
 * @since JDK 1.8
 */

@Configuration
public class QuartzConfiguration {

	@Bean
	public JobDetail weatherDataSyncJobJobDetail() {
		// 使用JobBuilder将获取天气定时任务创建出来，名称为 “weatherDataSyncJob”
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
	}
	
	@Bean
	public Trigger weatherDataSyncTrigger() {
		
		// 设置定时任务，30分钟执行一次,运行期间一直重复
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
																	.withIntervalInMinutes(30).repeatForever();
		
		// 触发器 分别设置触发的任务(weatherDataSyncJob)、触发计划(schedBuilder)、触发器名称(weatherDataSyncTrigger)
		return TriggerBuilder.newTrigger()
							.forJob(weatherDataSyncJobJobDetail())
							.withIdentity("weatherDataSyncTrigger")
							.withSchedule(schedBuilder)
							.build();
	}
}
