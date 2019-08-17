package com.bzh.springcloud.weather.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * 将xml转换为实体类
 * @ClassName: XMLBuilder
 * @author BaiZehong
 * @date 2019年8月13日
 * @since JDK 1.8
 */
public class XMLBuilder {
	
	public static Object xmlStrToObject(Class<?> clazz, String xmlString) throws JAXBException, IOException {
		
		Object xmlObject = null;
		JAXBContext context = JAXBContext.newInstance(clazz);// 生成一个实体实例
		
		//XML转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Reader reader = new StringReader(xmlString);
		xmlObject = unmarshaller.unmarshal(reader);// 将xmlString 作为参数传进去
		
		if (reader != null) {
			reader.close();
		}
		return xmlObject;
	}
	

}
