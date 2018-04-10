package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.core.handler.ConsumerHandler;
import com.eilikce.osm.entity.consumer.ConsumerPo;

public class Consumer extends EntityTransBo<ConsumerPo>{
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

	public Consumer(String addr, String name, String phone) {
		super();
		this.consumerId = ConsumerHandler.consumerIdCreater(name, phone, addr);
		this.extraId = "";
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}
	
	public Consumer(ConsumerPo consumer) {
		super();
		this.id = consumer.getId();
		this.consumerId = consumer.getConsumerId();
		this.extraId = consumer.getExtraId();
		this.addr = consumer.getAddr();
		this.name = consumer.getName();
		this.phone = consumer.getPhone();
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

	/**
	 * 返回Consumer对象
	 * @return
	 */
	public ConsumerPo ConsumerTransform(){
		ConsumerPo consumer = new ConsumerPo(consumerId, extraId, addr, name, phone);
		return consumer;
	}
	
	@Override
	public String toString() {
		return "ConsumerBo [id=" + id + ", consumerId=" + consumerId + ", extraId=" + extraId + ", addr=" + addr
				+ ", name=" + name + ", phone=" + phone + "]";
	}

}
