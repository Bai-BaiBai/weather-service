package com.bzh.springcloud.weather.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * ��xmlת��Ϊʵ����
 * @ClassName: XMLBuilder
 * @author BaiZehong
 * @date 2019��8��13��
 * @since JDK 1.8
 */
public class XMLBuilder {
	
	public static Object xmlStrToObject(Class<?> clazz, String xmlString) throws JAXBException, IOException {
		
		Object xmlObject = null;
		JAXBContext context = JAXBContext.newInstance(clazz);// ����һ��ʵ��ʵ��
		
		//XMLתΪ����Ľӿ�
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Reader reader = new StringReader(xmlString);
		xmlObject = unmarshaller.unmarshal(reader);// ��xmlString ��Ϊ��������ȥ
		
		if (reader != null) {
			reader.close();
		}
		return xmlObject;
	}
	

}
