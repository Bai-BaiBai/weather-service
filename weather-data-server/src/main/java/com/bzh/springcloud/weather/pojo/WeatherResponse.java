package com.bzh.springcloud.weather.pojo;

import java.io.Serializable;

/**
 * �н�api�ӿڷ��ص���������
 * @ClassName: WeatherResponse
 * @Description: �н�api�ӿڷ��ص���������
 * @author BaiZehong
 * @date 2019��8��12��
 * @since JDK 1.8
 */
public class WeatherResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��������
	 */
	private Weather data;
	
	/**
	 * ״̬��
	 */
	private Integer status;
	
	/**
	 * ״̬����
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
