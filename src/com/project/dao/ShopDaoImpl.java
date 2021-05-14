package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Item;
import com.project.model.Shop;
import com.project.service.ShopService;
import com.project.service.ShopServiceImpl;
import com.project.utility.DBConnection;

public class ShopDaoImpl implements ShopDao {
	static ShopService service = new ShopServiceImpl();
	static ItemDao it = new ItemDaoImpl();

	@Override
	public String addShopdetails(List<Shop> shop) throws ConnectionFailedException {
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		String str = null;
		String query = "insert into shop(shopId,shopName,address) values(?,?,?);";
		Shop obj = shop.get(0);
		try {
			st = con.prepareStatement(query);
			st.setInt(1, obj.getShopId());
			st.setString(2, obj.getShopName());
			st.setString(3, obj.getAddress());
			st.executeUpdate();
			String s = it.addItem(obj.getItem());
			str = "Shop ID with '" + obj.getShopId() + "' was succesfully inserted";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				throw new ConnectionFailedException();

			}

		}
		return str;
	}

	@Override
	public List<Shop> displayShopDetails() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from shop;";
		List<Shop> shop = new ArrayList<Shop>();
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {

				List<Item> item = new ArrayList<Item>();
				int shopId = res.getInt("shopId");
				String shopName = res.getString("shopName");
				String address = res.getString("address");
				String query = "select * from item where shopId='" + shopId + "';";
				Statement st2 = con.createStatement();
				ResultSet res2 = st2.executeQuery(query);
				while (res2.next()) {
					Item itm = new Item(res2.getInt("itemId"), res2.getString("itemName"), res2.getDouble("price"),
							res2.getInt("shopId"));
					item.add(itm);
				}
				Shop sh = new Shop(shopId, shopName, address, item);
				shop.add(sh);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shop;
	}

	public void displayShops() {
		Connection con = DBConnection.getConnection();
		String sql = "select * from shop;";
		TreeSet<Shop> shop = new TreeSet<Shop>();
		HashMap<Integer, String> map = new HashMap<>();
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				int shopId = res.getInt("shopId");
				String shopName = res.getString("shopName");
				String address = res.getString("address");
				Shop s = new Shop(shopId, shopName, address);

				map.put(s.getShopId(), s.getShopName());

			}
			for (Map.Entry m : map.entrySet()) {
				System.out.println(m.getKey() + " " + m.getValue());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Shop searchShopByName(String shopName) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		Shop shop = null;
		List<Item> i = new ArrayList<Item>();
		try {
			String sql = "select * from shop s INNER JOIN item m " + "WHERE m.shopId = s.shopId AND s.shopName='"
					+ shopName + "';";
			Statement st = con.createStatement();
			ResultSet res2 = st.executeQuery(sql);
			while (res2.next()) {
				int shopId = res2.getInt("shopId");
				String shopName1 = res2.getString("shopName");
				String address = res2.getString("address");

				while (res2.next()) {
					Item itm = new Item(res2.getInt("itemId"), res2.getString("itemName"), res2.getDouble("price"),
							res2.getInt("shopId"));
					i.add(itm);

				}
				shop = new Shop(shopId, shopName1, address, i);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return shop;

	}

	@Override
	public String deleteShop(String shopId) {
		// TODO Auto-generated method stub
		String str = null;
		Connection con = DBConnection.getConnection();
		String sql = "delete from shop where shopId = '" + shopId + "';";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.execute();
			str = "The Shop with ShopID: '" + shopId + "' was successfully deleted;";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
	}

}
