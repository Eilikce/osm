package com.eilikce.osm.api.repository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eilikce.osm.api.repository.module.ApiView;
import com.eilikce.osm.api.repository.service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	ApiService apiService;
	
	@RequestMapping(value="api/apiData",method=RequestMethod.GET)
	List<ApiView> apiData() {
		
		List<ApiView> data = apiService.apiData();
		
		return data;
	}
}
