package com.eilikce.osm.api.repository.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.api.repository.config.OsmUserConfig;
import com.eilikce.osm.api.repository.module.User;

@Service
public class HomeService {
	
	@Autowired
	private OsmUserConfig osmUserConfig;
	
	public String login(HttpServletRequest request) {
		String account = request.getParameter("account");
		String pass = request.getParameter("pass");

		if(osmUserConfig.getName().equals(account)&&osmUserConfig.getPassword().equals(pass)){
			User user = new User(account, pass);
			request.getSession().setAttribute("user", user);
			return "success";
		}
		
		return "failed";
	}
}
