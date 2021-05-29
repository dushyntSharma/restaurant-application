package com.project.dao;

import java.util.List;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Item;

public interface ItemDao {

	/**
	 * @param item
	 * @return string value if the items are added
	 * @throws ConnectionFailedException
	 */
	String addItem(List<Item> item) throws ConnectionFailedException;

}
