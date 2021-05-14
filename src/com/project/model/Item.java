package com.project.model;

public class Item {
	private int itemId;
	private String itemName;
	private double price;
	private int shopId;

	public Item(int itemId, String itemName, double price, int shopId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.shopId = shopId;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", shopId=" + shopId + "]";
	}

}
