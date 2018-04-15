package com.eilikce.osm.entity.consumer;

import com.eilikce.osm.entity.CommonEntityPo;

public class ConsumerPo extends CommonEntityPo{
	private String consumerId;
	private String extraId;
	private String addr;
	private String name;
	private String phone;

	public ConsumerPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsumerPo(String consumerId, String extraId, String addr, String name, String phone) {
		super();
		this.consumerId = consumerId;
		this.extraId = extraId;
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getExtraId() {
		return extraId;
	}

	public void setExtraId(String extraId) {
		this.extraId = extraId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ConsumerPo [consumerId=" + consumerId + ", extraId=" + extraId + ", addr=" + addr + ", name=" + name
				+ ", phone=" + phone + "]";
	}

}
