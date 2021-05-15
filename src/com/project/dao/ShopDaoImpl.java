package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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

	// take the inputs from the users and add them to the database
	// get the connection from the utility package
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
		}
		// close the resources that are used

		finally {
			try {
				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				e.printStackTrace();

			}

		}
		return str;
	}

	// displaying the data from the database
	// get the connection from the utility
	@Override
	public List<Shop> displayShopDetails() throws ConnectionFailedException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from shop;";
		Statement st = null;
		ResultSet res = null;
		List<Shop> shop = new ArrayList<Shop>();
		try {
			st = con.createStatement();
			res = st.executeQuery(sql);
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
		// close the resources
		finally {
			try {
				ConnectionFailedException.closeResource(res);
				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				e.printStackTrace();

			}

		}
		return shop;
	}

	// display the shop using the HashMap and TreeSet
	public void displayShops() throws ConnectionFailedException {
		Connection con = DBConnection.getConnection();
		String sql = "select * from shop;";
		Statement st = null;
		ResultSet res = null;
		TreeSet<Shop> shop = new TreeSet<Shop>();
		HashMap<Integer, String> map = new HashMap<>();
		try {
			st = con.createStatement();
			res = st.executeQuery(sql);
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
		// close the resources
		finally {
			try {
				ConnectionFailedException.closeResource(res);
				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				e.printStackTrace();

			}

		}
	}

	// searching the shop based on the shopName from the user
	@Override
	public Shop searchShopByName(String shopName) throws ConnectionFailedException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		Shop shop = null;
		Statement st = null;
		ResultSet res2 = null;
		List<Item> i = new ArrayList<Item>();
		try {
			// using the inner joins to search the shop
			String sql = "select * from shop s INNER JOIN item m " + "WHERE m.shopId = s.shopId AND s.shopName='"
					+ shopName + "';";
			st = con.createStatement();
			res2 = st.executeQuery(sql);
			// get the shop details
			while (res2.next()) {
				int shopId = res2.getInt("shopId");
				String shopName1 = res2.getString("shopName");
				String address = res2.getString("address");
				// get the item details
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
		// close the resources
		finally {
			try {
				ConnectionFailedException.closeResource(res2);
				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				e.printStackTrace();

			}

		}

		return shop;

	}

	// deleting the shop based on the shopId
	@Override
	public String deleteShop(String shopId) throws ConnectionFailedException {
		// TODO Auto-generated method stub
		String str = null;
		PreparedStatement st = null;
		Connection con = DBConnection.getConnection();
		String sql = "delete from shop where shopId = '" + shopId + "';";
		try {
			st = con.prepareStatement(sql);
			st.execute();
			str = "The Shop with ShopID: '" + shopId + "' was successfully deleted;";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// close the resources
		finally {
			try {

				ConnectionFailedException.closeResource(st);
				ConnectionFailedException.closeResource(con);

			} catch (ConnectionFailedException e) {
				e.printStackTrace();

			}

		}
		return str;
	}

}
