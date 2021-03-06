package com.project.service;

import java.util.HashSet;
import java.util.List;

import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;
import com.project.dao.ShopDao;
import com.project.dao.ShopDaoImpl;
import com.project.exceptions.ConnectionFailedException;
import com.project.model.Shop;

public class ShopServiceImpl implements ShopService {
	static ShopDao dao = new ShopDaoImpl();
	static ItemDao cdao = new ItemDaoImpl();

	// adding the shops
	@Override
	public String addShopDetails(List<Shop> shop) {
		String s = null;
		try {
			// send to the dao layer
			s = dao.addShopdetails(shop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	// display shops
	@Override
	public List<Shop> displayShopDetails() throws ConnectionFailedException {
		// TODO Auto-generated method stub
		List<Shop> shop = dao.displayShopDetails();
		return shop;
	}

	// search the shop by name
	@Override
	public Shop searchShopByName(String shopName) throws ConnectionFailedException {
		// TODO Auto-generated method stub
		Shop shop = dao.searchShopByName(shopName);
		return shop;
	}

	// delete the shop
	@Override
	public String deleteShop(String shopId) throws ConnectionFailedException {
		// TODO Auto-generated method stub
		String str = dao.deleteShop(shopId);
		return str;
	}

	@Override
	public void displayShops() throws ConnectionFailedException {
		dao.displayShops();

	}

	@Override
	public HashSet<Shop> displayShopByHasMap() {
		// TODO Auto-generated method stub
		HashSet<Shop> shop = dao.displayShopByHasMap();
		return shop;
	}

}
