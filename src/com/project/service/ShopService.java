package com.project.service;

import java.util.List;

import com.project.model.Shop;

public interface ShopService {

	String addShopDetails(List<Shop> shop);

	List<Shop> displayShopDetails();

	Shop searchShopByName(String shopName);

	String deleteShop(String shopId);

	void displayShops();

}
