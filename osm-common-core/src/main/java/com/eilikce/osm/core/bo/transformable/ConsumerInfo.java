package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.core.handler.OsmIdHandler;
import com.eilikce.osm.entity.consumer.ConsumerPo;
import com.eilikce.osm.redis.entity.RedisStorable;

public class ConsumerInfo extends EntityTransBo<ConsumerPo> implements RedisStorable {

	private static final long serialVersionUID = 1L;
	
	private String consumerId;
	private String extraId;
	private String addr;
	private String name;
	private String phone;

	public ConsumerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsumerInfo(String addr, String name, String phone) {
		super();
		this.consumerId = OsmIdHandler.consumerIdCreater(name, phone, addr);
		this.extraId = "";
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}
	
	public ConsumerInfo(ConsumerPo consumer) {
		super();
		this.consumerId = consumer.getConsumerId();
		this.extraId = consumer.getExtraId();
		this.addr = consumer.getAddr();
		this.name = consumer.getName();
		this.phone = consumer.getPhone();
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
		return "ConsumerInfo [consumerId=" + consumerId + ", extraId=" + extraId + ", addr=" + addr + ", name=" + name
				+ ", phone=" + phone + "]";
	}

}
