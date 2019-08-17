package com.bzh.springcloud.weather.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息
 * @ClassName: Weather
 * @Description: 天气信息
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */
public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String city;// 城市名
	private String aqi;// aqi
	private String ganmao;// 感冒提示
	private String wendu;// 当日温度
	/**
	 * 昨日天气
	 */
	private Yeaterday yesterday;
	/**
	 * 未来天气
	 */
	private List<Forecast> forecast;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getGanmao() {
		return ganmao;
	}
	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public Yeaterday getYesterday() {
		return yesterday;
	}
	public void setYesterday(Yeaterday yesterday) {
		this.yesterday = yesterday;
	}
	public List<Forecast> getForecast() {
		return forecast;
	}
	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}

}
