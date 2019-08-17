package com.bzh.springcloud.weather.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市列表，通过xml读取
 * @ClassName: CityList
 * @author BaiZehong
 * @date 2019年8月13日
 * @since JDK 1.8
 */
@XmlRootElement(name="c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

	@XmlElement(name="d")
	private List<City> cityList;
	
	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
}
