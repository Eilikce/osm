package com.eilikce.osm.core.bo.transformable;

import java.io.Serializable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.consumer.ConsumerPo;

public class ConsumerInfo extends EntityTransBo<ConsumerPo> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String consumerId;
	private String addr;
	private String name;
	private String phone;

	public ConsumerInfo(String consumerId) {
		this.consumerId = consumerId;
	}

	public ConsumerInfo(String addr, String name, String phone) {
		super();
		this.consumerId = "";
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}
	
	public ConsumerInfo(ConsumerPo consumerPo) {
		super();
		this.consumerId = consumerPo.getConsumerId();
		this.addr = consumerPo.getAddr();
		this.name = consumerPo.getName();
		this.phone = consumerPo.getPhone();
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
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
		return "ConsumerInfo [consumerId=" + consumerId + ", addr=" + addr + ", name=" + name + ", phone=" + phone
				+ "]";
	}

}
