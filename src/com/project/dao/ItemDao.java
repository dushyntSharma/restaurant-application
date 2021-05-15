package com.project.dao;

import java.util.List;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Item;

public interface ItemDao {

	String addItem(List<Item> item) throws ConnectionFailedException;

}
