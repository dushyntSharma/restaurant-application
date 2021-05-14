package com.project.model;

import java.util.List;

public class Shop {
	private int shopId;
	private String shopName;
	private String address;
	private List<Item> item;

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(int shopId, String shopName, String address, List<Item> item) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.address = address;
		this.item = item;
	}

	public Shop(int shopId2, String shopName2, String address2) {
		// TODO Auto-generated constructor stub
		this.shopId = shopId2;
		this.shopName = shopName2;
		this.address = address2;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", address=" + address + ", item=" + item + "]";
	}

}
