package com.eilikce.osm.admin.bo.admin;

import java.sql.Timestamp;

import com.eilikce.osm.admin.bo.BoTransInter;
import com.eilikce.osm.entity.admin.Account;

public class AccountBo implements BoTransInter<Account>{
	private Integer id;
	private String accountId;
	private String orderId;
	private String orderCommodityId;
	private String commodityId;
	private String commodityName;
	private Integer barcode;
	private String unit;
	private Float original;
	private Float price;
	private Float profit;
	private Integer salesVolume;
	private Float accountOriginal;
	private Float accountPrice;
	private Float accountProfit;
	private String accountDetail;
	private Timestamp accountDate;

	public AccountBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountBo(Integer id, String accountId, String orderId, String orderCommodityId, String commodityId,
			String commodityName, Integer barcode, String unit, Float original, Float price, Float profit,
			Integer salesVolume, Float accountOriginal, Float accountPrice, Float accountProfit, String accountDetail,
			Timestamp accountDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.orderId = orderId;
		this.orderCommodityId = orderCommodityId;
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.barcode = barcode;
		this.unit = unit;
		this.original = original;
		this.price = price;
		this.profit = profit;
		this.salesVolume = salesVolume;
		this.accountOriginal = accountOriginal;
		this.accountPrice = accountPrice;
		this.accountProfit = accountProfit;
		this.accountDetail = accountDetail;
		this.accountDate = accountDate;
	}

	@Override
	public String toString() {
		return "AccountBo [id=" + id + ", accountId=" + accountId + ", orderId=" + orderId + ", orderCommodityId="
				+ orderCommodityId + ", commodityId=" + commodityId + ", commodityName=" + commodityName + ", barcode="
				+ barcode + ", unit=" + unit + ", original=" + original + ", price=" + price + ", profit=" + profit
				+ ", salesVolume=" + salesVolume + ", accountOriginal=" + accountOriginal + ", accountPrice="
				+ accountPrice + ", accountProfit=" + accountProfit + ", accountDetail=" + accountDetail
				+ ", accountDate=" + accountDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getBarcode() {
		return barcode;
	}

	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getOriginal() {
		return original;
	}

	public void setOriginal(Float original) {
		this.original = original;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getProfit() {
		return profit;
	}

	public void setProfit(Float profit) {
		this.profit = profit;
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Float getAccountOriginal() {
		return accountOriginal;
	}

	public void setAccountOriginal(Float accountOriginal) {
		this.accountOriginal = accountOriginal;
	}

	public Float getAccountPrice() {
		return accountPrice;
	}

	public void setAccountPrice(Float accountPrice) {
		this.accountPrice = accountPrice;
	}

	public Float getAccountProfit() {
		return accountProfit;
	}

	public void setAccountProfit(Float accountProfit) {
		this.accountProfit = accountProfit;
	}

	public String getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(String accountDetail) {
		this.accountDetail = accountDetail;
	}

	public Timestamp getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Timestamp accountDate) {
		this.accountDate = accountDate;
	}

	public String getOrderCommodityId() {
		return orderCommodityId;
	}

	public void setOrderCommodityId(String orderCommodityId) {
		this.orderCommodityId = orderCommodityId;
	}

	@Override
	public Account transToEntity() {
		Account account = new Account(id, accountId, orderId, orderCommodityId, commodityId, commodityName, barcode, unit, original, price, profit, salesVolume, accountOriginal, accountPrice, accountProfit, accountDetail, accountDate);
		return account;
	}

	@Override
	public BoTransInter<?> fillWithEntity(Account account) {
		this.id = account.getId();
		this.accountId = account.getAccountId();
		this.orderId = account.getOrderId();
		this.orderCommodityId = account.getOrderCommodityId();
		this.commodityId = account.getCommodityId();
		this.commodityName = account.getCommodityName();
		this.barcode = account.getBarcode();
		this.unit = account.getUnit();
		this.original = account.getOriginal();
		this.price = account.getPrice();
		this.profit = account.getProfit();
		this.salesVolume = account.getSalesVolume();
		this.accountOriginal = account.getOriginal();
		this.accountPrice = account.getAccountPrice();
		this.accountProfit = account.getAccountProfit();
		this.accountDetail = account.getAccountDetail();
		this.accountDate = account.getAccountDate();
		return this;
	}

}
