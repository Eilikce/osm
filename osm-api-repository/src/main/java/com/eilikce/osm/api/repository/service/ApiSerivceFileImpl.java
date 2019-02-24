package com.eilikce.osm.api.repository.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eilikce.osm.api.repository.module.ApiView;
import com.eilikce.osm.api.repository.util.ResourceLoader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiSerivceFileImpl implements ApiService {

	@Value("data/api-data.json")
	private String apiDataPath;

	@Override
	public List<ApiView> apiData() {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream apiStream = ResourceLoader.load(apiDataPath);
			List<ApiView> list = mapper.readValue(apiStream, new TypeReference<List<ApiView>>() { });
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
