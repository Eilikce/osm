package com.eilikce.osm.shop.exception;


/**
 * @author Eilik
 *	鉴权异常
 */
public class AuthorizationException extends Exception {
	
	private static final long serialVersionUID = 4944916743442751335L;

	private String errorMsg;

	public AuthorizationException(String errorMsg, Exception exception) {
		super(errorMsg,exception);
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
