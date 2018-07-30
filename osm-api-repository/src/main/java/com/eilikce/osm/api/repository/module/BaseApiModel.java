package com.eilikce.osm.api.repository.module;

public class BaseApiModel {
	private int code;
	private String msg;
	private String data;

	public BaseApiModel() {
		this.code = 4000;
		this.msg = "数据错误";
	}

	public BaseApiModel(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public BaseApiModel(int code, String msg, String data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BaseApiModel [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
