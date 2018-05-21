package com.eilikce.osm.wxsdk.authorization;

import org.json.JSONObject;

import com.qcloud.weapp.authorization.UserInfo;


/**
 * @author Eilik
 *	OSM微信消息载体模型
 */
public class OsmWxMsg {
	
	/**
	 * 用户信息
	 */
	private UserInfo userInfo;
	
	/**
	 * 信息json载体
	 */
	private String msgJson;
	
	/**
	 * 微信服务异常信息
	 */

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getMsgJson() {
		return msgJson;
	}

	public void setMsgJson(String msgJson) {
		this.msgJson = msgJson;
	}
	
	/**
	 * 微信信息保存入载体
	 * @param json
	 * @param osmWxMsg
	 */
	public void setMsgJson(JSONObject msgJson) {
		this.msgJson = msgJson.toString();
	}

	@Override
	public String toString() {
		return "OsmWxMsg [userInfo=" + userInfo + ", msgJson=" + msgJson + "]";
	}

}
