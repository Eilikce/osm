package com.eilikce.osm.core.bo;

import com.eilikce.osm.core.handler.BoTransInter;
import com.eilikce.osm.core.handler.ConsumerBoHandler;
import com.eilikce.osm.entity.consumer.Consumer;

public class ConsumerBo implements BoTransInter<Consumer>{
	private Integer id;
	private String consumerId;
	private String extraId;
	private String addr;
	private String name;
	private String phone;

	public ConsumerBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsumerBo(Integer id, String consumerId, String extraId, String addr, String name, String phone) {
		super();
		this.id = id;
		this.consumerId = consumerId;
		this.extraId = extraId;
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}

	public ConsumerBo(String addr, String name, String phone) {
		super();
		this.consumerId = ConsumerBoHandler.consumerIdCreater(name, phone, addr);
		this.extraId = "";
		this.addr = addr;
		this.name = name;
		this.phone = phone;
	}
	
	public ConsumerBo(Consumer consumer) {
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
	public Consumer ConsumerTransform(){
		Consumer consumer = new Consumer(consumerId, extraId, addr, name, phone);
		return consumer;
	}
	
	@Override
	public String toString() {
		return "ConsumerBo [id=" + id + ", consumerId=" + consumerId + ", extraId=" + extraId + ", addr=" + addr
				+ ", name=" + name + ", phone=" + phone + "]";
	}

	@Override
	public Consumer transToEntity() {
		Consumer consumer = new Consumer(consumerId, extraId, addr, name, phone);
		return consumer;
	}

	@Override
	public BoTransInter<?> fillWithEntity(Consumer consumer) {
		this.id = consumer.getId();
		this.consumerId = consumer.getConsumerId();
		this.extraId = consumer.getExtraId();
		this.addr = consumer.getAddr();
		this.name = consumer.getName();
		this.phone = consumer.getPhone();
		return this;
	}

}
