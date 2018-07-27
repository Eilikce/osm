package com.eilikce.osm.api.repository.module;

public class User {
	String account;
	String password;

	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + "]";
	}

}
