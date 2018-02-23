package com.eilikce.osm.entity.consumer;

import com.eilikce.osm.entity.CommonEntity;

public class Consumer extends CommonEntity{
	private Integer id;
	private String consumerId;
	private String extraId;
	private String addr;
	private String name;
	private String phone;

	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consumer(Integer id, String consumerId, String extraId, String addr, String name, String phone) {
		super();
		this.id = id;
		this.consumerId = consumerId;
		this.extraId = extraId;
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}

	public Consumer(String consumerId, String extraId, String addr, String name, String phone) {
		super();
		this.consumerId = consumerId;
		this.extraId = extraId;
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Consumer [id=" + id + ", consumerId=" + consumerId + ", extraId=" + extraId + ", addr=" + addr
				+ ", name=" + name + ", phone=" + phone + "]";
	}

}
