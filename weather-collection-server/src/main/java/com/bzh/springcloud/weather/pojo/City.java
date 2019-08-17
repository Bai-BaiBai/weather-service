package com.bzh.springcloud.weather.pojo;

/**
 * 城市信息
 * @ClassName: City
 * @author BaiZehong
 * @date 2019年8月13日
 * @since JDK 1.8
 */
public class City {

	private String cityId;
	
	private String cityName;

	private String cityCode;
	
	private String province;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
