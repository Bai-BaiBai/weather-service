package com.bzh.springcloud.weather.pojo;

import java.io.Serializable;

/**
 * 承接api接口返回的天气数据
 * @ClassName: WeatherResponse
 * @Description: 承接api接口返回的天气数据
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */
public class WeatherResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 天气数据
	 */
	private Weather data;
	
	/**
	 * 状态码
	 */
	private Integer status;
	
	/**
	 * 状态描述
	 */
	private String desc;
	
	public Weather getData() {
		return data;
	}
	public void setData(Weather data) {
		this.data = data;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
