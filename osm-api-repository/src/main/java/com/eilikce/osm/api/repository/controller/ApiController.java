package com.eilikce.osm.api.repository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eilikce.osm.api.repository.module.BaseApiModel;
import com.eilikce.osm.api.repository.service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	ApiService apiService;
	
	@RequestMapping(value="api/apiData",method=RequestMethod.GET)
	BaseApiModel apiData() {
		
		BaseApiModel data = apiService.apiData();
		
		return data;
	}
}
