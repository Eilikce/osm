package com.eilikce.osm.shop.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.eilikce.osm.dao.ConsumerDao;
import com.eilikce.osm.shop.session.SessionManager;

/**
 * 微信登录服务实现
 * 
 * @author Eilik
 *
 */
public class LoginServiceWxImpl implements LoginService {

	private static final Logger LOG = LoggerFactory.getLogger(LoginServiceWxImpl.class);

	@Autowired
	private SessionManager sessionManager;
	
	@Autowired
	private ConsumerDao consumerDao;

	@Override
	public String authorizedFailed() {
		return "authorizedFailed";
	}

    @Override
    public String login(HttpServletRequest request, HttpServletResponse response, Map<String, String> paramsMap) {
        return null;
    }


}
