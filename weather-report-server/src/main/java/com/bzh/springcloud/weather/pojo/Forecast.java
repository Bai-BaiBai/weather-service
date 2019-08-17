package com.bzh.springcloud.weather.pojo;

import java.io.Serializable;

/**
 * 未来天气
 * @ClassName: Forecast
 * @Description: 未来天气
 * @author BaiZehong
 * @date 2019年8月12日
 * @since JDK 1.8
 */
public class Forecast implements Serializable {

	private static final long serialVersionUID = 1L;
	private String date;// 日期
	private String high;// 最高温度
	private String fengli;// 风力
	private String low;// 最低温度
	private String fengxiang;// 风向
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
	public String getFengli() {
		return fengli;
	}
	public void setFengli(String fengli) {
		this.fengli = fengli;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getFengxiang() {
		return fengxiang;
	}
	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}