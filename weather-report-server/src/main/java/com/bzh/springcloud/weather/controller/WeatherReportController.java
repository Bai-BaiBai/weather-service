package com.bzh.springcloud.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.service.DataClient;
import com.bzh.springcloud.weather.service.WeatherReportService;

/**
 * ����������
 * 
 * @ClassName: WeatherController
 * @Description: ����������
 * @author BaiZehong
 * @date 2019��8��12��
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private WeatherReportService weatherReportService;
	
	@Autowired
	private DataClient dataClient;

	/**
	 * ǰ��ҳ�� ��ȡѡ��ĳ��е����� model�з��ص���Ϣ�� title��cityId��ȫ�������б�ָ����������Ԥ��
	 * 
	 * @Title: getReportByCityId
	 * @param cityId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {

		// ���ó�������API΢�����ȡ�����б����ݵ�ǰ��
		List<City> cityList = null;
		cityList = dataClient.listCity();

		model.addAttribute("title", "����Ԥ��");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList",cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

		return new ModelAndView("weather/report", "reportModel", model);
	}

}
