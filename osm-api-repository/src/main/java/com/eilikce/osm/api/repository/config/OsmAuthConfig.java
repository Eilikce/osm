package com.eilikce.osm.api.repository.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "osm.auth")
@PropertySource("classpath:config/osm.properties")
@Component
public class OsmAuthConfig {
	private boolean free;

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	@Override
	public String toString() {
		return "OsmAuthConfig [free=" + free + "]";
	}

}
