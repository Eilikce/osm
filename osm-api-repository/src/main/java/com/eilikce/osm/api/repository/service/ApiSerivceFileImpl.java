package com.eilikce.osm.api.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.eilikce.osm.api.repository.module.ApiView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiSerivceFileImpl implements ApiService {

	@Value(value = "classpath:data/api-data.json")
	private Resource data;

	@Override
	public List<ApiView> apiData() {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<ApiView> list = mapper.readValue(data.getFile(), new TypeReference<List<ApiView>>() { });
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
