package com.eilikce.osm.shop.session.wx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eilikce.osm.shop.exception.AuthorizationException;
import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.RedisSessionManager;

/**
 * 单例形式
 * 微信会话管理器
 * 
 * 用于获取会话和鉴权
 * 
 * @author wanghw
 *
 */
public class WxSessionManager extends RedisSessionManager{

    private static final Logger LOG = LoggerFactory.getLogger(WxSessionManager.class);

    @Override
    public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws AuthorizationException {
        return false;
    }

    @Override
    public OsmSession login(HttpServletRequest request, HttpServletResponse response) throws AuthorizationException {
        return null;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public OsmSession getSession(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public void saveSession(OsmSession session) {

    }

    @Override
    public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}