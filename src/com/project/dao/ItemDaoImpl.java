package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Item;
import com.project.utility.DBConnection;

public class ItemDaoImpl implements ItemDao {

	// adding the item from the user to the database
	// taking the connection from the DBConnection package
	@Override
	public String addItem(List<Item> item) throws ConnectionFailedException {
		Connection con = DBConnection.getConnection();
		PreparedStatement st = null;
		String query2 = "insert into item(itemId,itemName,price,shopId) values(?,?,?,?);";
		try {
			for (int i = 0; i < item.size(); i++) {
				st = con.prepareStatement(query2);
				st.setInt(1, item.get(i).getItemId());
				st.setString(2, item.get(i).getItemName());
				st.setDouble(3, item.get(i).getPrice());
				st.setDouble(4, item.get(i).getShopId());
				st.execute();

			}

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

		return null;
	}

}
