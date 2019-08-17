package com.bzh.springcloud.weather.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * ������Ϣ
 * @ClassName: Weather
 * @Description: ������Ϣ
 * @author BaiZehong
 * @date 2019��8��12��
 * @since JDK 1.8
 */
public class Weather implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String city;// ������
	private String aqi;// aqi
	private String ganmao;// ��ð��ʾ
	private String wendu;// �����¶�
	/**
	 * ��������
	 */
	private Yeaterday yesterday;
	/**
	 * δ������
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
