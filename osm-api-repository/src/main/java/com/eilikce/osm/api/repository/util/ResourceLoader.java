package com.eilikce.osm.api.repository.util;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceLoader {
	
	/**
	 * 以流形式读取路径资源
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static InputStream load(String path) throws IOException {
		Resource resource = new ClassPathResource(path);
		return resource.getInputStream();
	}
	
}
