package com.bzh.springcloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bzh.springcloud.weather.pojo.WeatherResponse;
import com.bzh.springcloud.weather.service.CityDataService;
import com.bzh.springcloud.weather.service.WeatherDataService;
import com.bzh.springcloud.weather.service.WeatherReportService;

/**
 * 天气控制器
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
	private CityDataService cityDataService;
	
	/**
	 * 前端页面 获取选择的城市的天气
	 * model中返回的信息有 title、cityId、全部城市列表、指定城市天气预报
	 * @Title: getReportByCityId
	 * @param cityId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		
		model.addAttribute("title", "天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityDataService.listCity());
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		
		return new ModelAndView("weather/report", "reportModel", model);
	}
	
}
