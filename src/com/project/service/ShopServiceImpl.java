package com.project.service;

import java.util.List;

import com.project.dao.ItemDao;
import com.project.dao.ItemDaoImpl;
import com.project.dao.ShopDao;
import com.project.dao.ShopDaoImpl;
import com.project.model.Shop;

public class ShopServiceImpl implements ShopService {
	static ShopDao dao = new ShopDaoImpl();
	static ItemDao cdao = new ItemDaoImpl();

	@Override
	public String addShopDetails(List<Shop> shop) {
		String s = null;
		try {
			s = dao.addShopdetails(shop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Shop> displayShopDetails() {
		// TODO Auto-generated method stub
		List<Shop> shop = dao.displayShopDetails();
		return shop;
	}

	@Override
	public Shop searchShopByName(String shopName) {
		// TODO Auto-generated method stub
		Shop shop = dao.searchShopByName(shopName);
		return shop;
	}

	@Override
	public String deleteShop(String shopId) {
		// TODO Auto-generated method stub
		String str = dao.deleteShop(shopId);
		return str;
	}

	@Override
	public void displayShops() {
		dao.displayShops();

	}

}
