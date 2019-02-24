package com.eilikce.osm.api.repository.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "osm.user")
@PropertySource("classpath:config/osm.properties")
@Component
public class OsmUserConfig {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EilikceConfig [name=" + name + ", password=" + password + "]";
	}

}
