package com.truYum.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.truYum.app.Repository.CustomerRepo;
import com.truYum.app.persitant.MenuItems;
@RestController
@ResponseBody
public class CustomerController{
	
	/**
	 * 
	 */
	
	@Autowired
	private CustomerRepo repo;
	
	@PostMapping("/addtocart")
	public ResponseEntity<String> addToCart(@RequestParam String name) {
	    String response = repo.addToCart(name);
	    return ResponseEntity.ok(response);
	}
	@DeleteMapping("removefromcart/{name}")
	public String RemoveFromCart(@PathVariable String name) {
		return repo.removeFromCart(name);
	}
	@GetMapping("viewcart")
	public String ViewCart() {
		return repo.viewCart();
	}
	@GetMapping("showitems")
	public List<MenuItems> viewItems(){
		return repo.ShowMenuItems();
	}
}
