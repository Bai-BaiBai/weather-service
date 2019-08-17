package com.bzh.springcloud.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Configuration
 * @ClassName: RestConfiguration
 * @author BaiZehong
 * @date 2019Äê8ÔÂ12ÈÕ
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
