package com.project.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.project.exceptions.ConnectionFailedException;
import com.project.model.Item;
import com.project.model.Shop;
import com.project.service.ShopService;
import com.project.service.ShopServiceImpl;

public class ShopApplication {
	static Scanner sc = new Scanner(System.in);
	static ShopService service = new ShopServiceImpl();

	public static void main(String[] args) throws ConnectionFailedException {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// adding the shop details
				String s = addShopDetails();
				System.out.println(s);
				break;
			case 2:
				// displaying the shop details
				List<Shop> shop = service.displayShopDetails();
				System.out.println(shop.toString());
				break;
			case 3:
				// search the shop name based on the shopName
				System.out.println("Enter the shop name");
				String shopName = sc.next();
				Shop s1 = service.searchShopByName(shopName);
				System.out.println(s1.toString());
				break;
			case 4:
				// Deleting the shop based in the shopId
				System.out.println("Enter the shopId to Delete");
				String shopId = sc.next();
				String str = service.deleteShop(shopId);
				System.out.println(str);
				break;

			case 5:
				// display the shop and items details
				List<Shop> shop1 = service.displayShopDetails();
				// using the comparator to sort the shop based on the shopName
				Collections.sort(shop1, new Comparator<Shop>() {

					@Override
					public int compare(Shop o1, Shop o2) {
						// TODO Auto-generated method stub
						return o1.getShopName().compareTo(o2.getShopName());
					}
				});
				// using the filter stream to display the shop based on the names
				shop1.stream().filter(t -> t.getShopId() > 1).forEach(t -> System.out.println(t));
				break;

			case 6:
				// display the shops based on the HashMap and TreeSet
				service.displayShops();
				break;
			case 7:
				// exit
				System.out.println("Thank you");
				flag = false;
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag);
	}

	// adding the shop details
	// using the arraylist to store them
	private static String addShopDetails() {
		// TODO Auto-generated method stub
		List<Shop> shop = new ArrayList<Shop>();
		System.out.println("Enter the Shop ID");
		int shopId = sc.nextInt();
		System.out.println("Enter the shop name");
		String shopName = sc.next();
		System.out.println("Enter the address");
		sc.nextLine();
		String address = sc.next();
		System.out.println("Enter the no of items you want?");
		int n = sc.nextInt();
		List<Item> item = new ArrayList<Item>(n);
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the item Id");
			int itemId = sc.nextInt();
			System.out.println("ENter the item name");
			String itemName = sc.next();
			System.out.println("Enter the price");
			double price = sc.nextDouble();
			Item c = new Item(itemId, itemName, price, shopId);
			item.add(c);

		}
		Shop b = new Shop(shopId, shopName, address, item);
		shop.add(b);

		String s = service.addShopDetails(shop);
		return s;
	}

	// display menu method
	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("1.Add Shop Details");
		System.out.println("2.Display Shop details");
		System.out.println("3.Search the Shop By its Name");
		System.out.println("4.Delete Shop");
		System.out.println("5.Sort Shop By Name");
		System.out.println("6.Display Shops(HashMap)");
		System.out.println("7.Exit");
		System.out.println();

	}

}
