package com.bzh.springcloud.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Configuration
 * 通信工具，调用第三方接口获取响应体(getForEntity)
 * @ClassName: RestConfiguration
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */

@Configuration
public class RestConfiguration {

	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}
}
