package com.eilikce.osm.wxsdk.authorization;

/**
 * Osm登录异常
 * 表示登录异常
 * */
public class OsmLoginServiceException extends Exception {
	
	private static final long serialVersionUID = 7179434716738339025L;
	private String type;
	/**
	 * 登录异常信息json形式
	 */
	private String errorMsgJson;
	
	public OsmLoginServiceException(String type, String message, Exception innerException) {
		super(message, innerException);
		this.type = type;
	}
	
	public OsmLoginServiceException(String type, String message) {
		this(type, message, null);
	}

	public String getErrorMsgJson() {
		return errorMsgJson;
	}

	public void setErrorMsgJson(String errorMsgJson) {
		this.errorMsgJson = errorMsgJson;
	}

	/**
	 * 获取登录异常的类型，具体的取值可参考 Constans 里面的常量
	 * @see com.qcloud.weapp.authorization.Constants
	 * */
	public String getType() {
		return this.type;
	}

}
