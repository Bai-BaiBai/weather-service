package com.bzh.springcloud.weather.pojo;

import java.io.Serializable;

/**
 * 昨日天气
 * @ClassName: Yesterday
 * @Description: 昨日天气
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */
public class Yeaterday implements Serializable {
	private static final long serialVersionUID = 1L;
	private String date;// 日期
	private String high;// 最高温度
	private String fx;// 风向
	private String low;// 最低温度
	private String fl;// 风力
	private String type;// 天气类型
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
