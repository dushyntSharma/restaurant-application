package com.project.dao;

import java.util.HashSet;
import java.util.List;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Shop;

public interface ShopDao {

	/**
	 * @param shop
	 * @return list of shops that are added
	 * @throws ConnectionFailedException
	 */
	String addShopdetails(List<Shop> shop) throws ConnectionFailedException;

	/**
	 * @return shop details from the database
	 * @throws ConnectionFailedException
	 */
	List<Shop> displayShopDetails() throws ConnectionFailedException;

	/**
	 * @param shopName
	 * @return the shop name searched
	 * @throws ConnectionFailedException
	 */
	Shop searchShopByName(String shopName) throws ConnectionFailedException;

	/**
	 * @param shopId
	 * @return deleted shop id
	 * @throws ConnectionFailedException
	 */
	String deleteShop(String shopId) throws ConnectionFailedException;

	/**
	 * @throws ConnectionFailedException
	 */
	void displayShops() throws ConnectionFailedException;

	HashSet<Shop> displayShopByHasMap();

}
