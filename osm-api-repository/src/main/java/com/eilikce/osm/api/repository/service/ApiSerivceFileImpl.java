package com.eilikce.osm.api.repository.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.eilikce.osm.api.repository.module.BaseApiModel;

@Service
public class ApiSerivceFileImpl implements ApiService {

	@Value(value = "classpath:data/api-data.json")
	private Resource data;

	@Override
	public BaseApiModel apiData() {
		
		try {
			String jsonData = "";
			return new BaseApiModel(1000, "Api数据获取成功", jsonData);
		} catch (Exception e) {
			return new BaseApiModel();
		}
	}

}
