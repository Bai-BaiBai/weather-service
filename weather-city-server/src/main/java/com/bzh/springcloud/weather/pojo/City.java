package com.bzh.springcloud.weather.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市信息，通过xml读取
 * @ClassName: City
 * @author BaiZehong
 * @date 2019年8月13日
 * @since JDK 1.8
 */
@XmlRootElement(name="d")
@XmlAccessorType(XmlAccessType.FIELD)// xml访问类型，映射到字段
public class City {

	@XmlAttribute(name="d1")
	private String cityId;
	
	@XmlAttribute(name="d2")
	private String cityName;

	@XmlAttribute(name="d3")
	private String cityCode;
	
	@XmlAttribute(name="d4")
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
