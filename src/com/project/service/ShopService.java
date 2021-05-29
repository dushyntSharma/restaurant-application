package com.project.service;

import java.util.HashSet;
import java.util.List;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Shop;

public interface ShopService {

	/**
	 * @param shop
	 * @return added shops
	 */
	String addShopDetails(List<Shop> shop);

	/**
	 * @return display of shops
	 * @throws ConnectionFailedException
	 */
	List<Shop> displayShopDetails() throws ConnectionFailedException;

	/**
	 * @param shopName
	 * @return searched shop by id
	 * @throws ConnectionFailedException
	 */
	Shop searchShopByName(String shopName) throws ConnectionFailedException;

	/**
	 * @param shopId
	 * @return deleted shop name
	 * @throws ConnectionFailedException
	 */
	String deleteShop(String shopId) throws ConnectionFailedException;

	/**
	 * @throws ConnectionFailedException
	 */
	void displayShops() throws ConnectionFailedException;

	HashSet<Shop> displayShopByHasMap();

}
