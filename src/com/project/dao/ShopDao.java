package com.project.dao;

import java.util.List;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Shop;

public interface ShopDao {

	String addShopdetails(List<Shop> shop) throws ConnectionFailedException;

	List<Shop> displayShopDetails() throws ConnectionFailedException;

	Shop searchShopByName(String shopName) throws ConnectionFailedException;

	String deleteShop(String shopId) throws ConnectionFailedException;

	void displayShops() throws ConnectionFailedException;

}
