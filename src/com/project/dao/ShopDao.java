package com.project.dao;

import java.util.List;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Shop;

public interface ShopDao {

	String addShopdetails(List<Shop> shop) throws ConnectionFailedException;

	List<Shop> displayShopDetails();

	Shop searchShopByName(String shopName);

	String deleteShop(String shopId);

	void displayShops();

}
