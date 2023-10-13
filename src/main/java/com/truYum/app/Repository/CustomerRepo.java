package com.truYum.app.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.truYum.app.persitant.MenuItems;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepo {
	public static int price=0;
	@Autowired
	private AdminRepo repo=new AdminRepo();
	public static List<MenuItems> cartlist=new ArrayList<>();
	@Transactional
	public String addToCart(String name) {
		List<MenuItems> itemList = repo.getAllItems();
		int id=0;
		boolean istrue=false;
			for(MenuItems item:itemList) {
				if(item.getName().equals(name) && item.getAvailability().equals("Yes")) {
					id=item.getId();
					istrue=true;
					break;
				}
			}
			if(!istrue) {
				return "Not found that item";
			}
			MenuItems item = repo.getItemById(id);
			cartlist.add(item);
			System.out.println("Item added succesfully....");
			price+=item.getPrice();
		return "Items: "+cartlist+"\nTotal Price: "+price;
	}
	@Transactional
	public String removeFromCart(String name) {
		List<MenuItems> itemList = repo.getAllItems();
		int id=0;
		boolean istrue=false;
		if(!cartlist.isEmpty()) {
		for(MenuItems item:itemList) {
			if(item.getName().equals(name) && item.getAvailability().equals("Yes")) {
				id=item.getId();
				break;
			}
		}
		if(!istrue) {
			return "Not found that item";
		}
		MenuItems item = repo.getItemById(id);
		price-=item.getPrice();
		cartlist.remove(item);
		System.out.println("Item removed succesfully....");
	}
		else {
			return "Bhai kuch add to karle pehle......";
		}
		return "Items: "+cartlist+"\nTotal Price: "+price;
	}
	@Transactional
	public String viewCart() {
		return "Items: "+cartlist+"\nTotal Price: "+price;
	}
	@Transactional
	public List<MenuItems> ShowMenuItems(){
		List<MenuItems> showitemList=new ArrayList<>();
		List<MenuItems> itemList = repo.getAllItems();
		for(MenuItems item:itemList) {
			if(item.getAvailability().equals("Yes")) {
				showitemList.add(item);
			}
		}
		return showitemList;
	}
}
