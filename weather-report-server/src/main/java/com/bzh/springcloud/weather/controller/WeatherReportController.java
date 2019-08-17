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
 * 天气控制器
 * 
 * @ClassName: WeatherController
 * @Description: 天气控制器
 * @author BaiZehong
 * @date 2019年8月12日
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
	 * 前端页面 获取选择的城市的天气 model中返回的信息有 title、cityId、全部城市列表、指定城市天气预报
	 * 
	 * @Title: getReportByCityId
	 * @param cityId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {

		// 调用城市数据API微服务获取城市列表，传递到前端
		List<City> cityList = null;
		cityList = dataClient.listCity();

		model.addAttribute("title", "天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList",cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

		return new ModelAndView("weather/report", "reportModel", model);
	}

}
