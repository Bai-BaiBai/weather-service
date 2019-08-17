package com.bzh.springcloud.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bzh.springcloud.weather.pojo.City;
import com.bzh.springcloud.weather.service.CityDataService;

@RestController
public class CityController {
	
	@Autowired
	private CityDataService cityDataService;

	@GetMapping("/cities")
	public List<City> listCity() throws Exception {
		
		return cityDataService.listCity();
	}
}
