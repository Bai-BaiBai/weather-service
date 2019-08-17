package com.bzh.springcloud.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.pojo.CityList;
import com.bzh.springcloud.weather.utils.XMLBuilder;

@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		
		// ��ȡXML�ļ�
		Resource resource = new ClassPathResource("citylist.xml");// Spring�ṩ�Ķ�ȡ����·�����ļ�����
		BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		
		while((line = bf.readLine()) != null) {
			buffer.append(line);
		}
		// ��XML����ת����ΪJava����
		CityList cityList = (CityList) XMLBuilder.xmlStrToObject(CityList.class, buffer.toString());
		
		return cityList.getCityList();
	}

}
