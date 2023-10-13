package com.truYum.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.truYum.app.Repository.AdminRepo;
import com.truYum.app.persitant.MenuItems;


@RestController
//@RequestMapping("/admin")
@ResponseBody
public class AdminController {
	@Autowired
	private AdminRepo repo;
	
	@PostMapping("additem/{name}/{price}/{isavail}/{dateoflaunch}/{isfreedel}")
	public MenuItems AddItem(@PathVariable String name, @PathVariable int price, @PathVariable String isavail,@PathVariable String dateoflaunch,@PathVariable String isfreedel) {
		MenuItems item = new MenuItems(name,price,isavail,dateoflaunch,isfreedel);
		repo.saveItem(item);
		System.out.println("Item Saved successfully......");
		return item;
	}

	@PostMapping("/updateItem/{id}")
	public ResponseEntity<Map<String, Object>> updateItem(@PathVariable int id, @RequestBody MenuItems updatedItem) throws Exception {
	    // Retrieve the existing item from the database based on the provided 'id'
		System.out.println("Updated user : "+updatedItem);
	    MenuItems existingItem = repo.getItemById(id);
	    System.out.println("Existing user : "+existingItem);

//	    if (existingItem == null) {
//	        // Handle the case where the item with the given 'id' is not found
//	        throw new Exception("Item with ID " + id + " not found");
//	    }

	    // Update the existing item's properties with the new values
	    existingItem.setName(updatedItem.getName());
	    existingItem.setPrice(updatedItem.getPrice());
	    existingItem.setDateOfLaunch(updatedItem.getDateOfLaunch());
	    existingItem.setAvailability(updatedItem.getAvailability());
	    existingItem.setFreeDelivery(updatedItem.isFreeDelivery());

	    // Save the updated item back to the database
	    repo.saveItem(existingItem);

	    Map<String, Object> response = new HashMap<>();
	    response.put("success", true);
	    
	    return ResponseEntity.ok(response);
	}

	@PutMapping("updateitembyprice/{id}/{price}")
	public MenuItems UpdateItemByPrice(@PathVariable int id,@PathVariable int price) {
		return repo.updateByPrice(id, price);
	}
	@PutMapping("updateitembyavailability/{id}/{isavail}")
	public List<MenuItems> UpdateItemByAvailability(@PathVariable int id,@PathVariable String isavail) {
		repo.updateByAvail(id, isavail);
		return repo.getAllItems();
	}
	@GetMapping("getallitems")
	public List<MenuItems> getAll(){
		return repo.getAllItems();
	}
	
	@DeleteMapping("delteitembyid/{id}")
	public List<MenuItems> deleteItemById(@PathVariable int id){
		repo.deleteItemsById(id);
		return repo.getAllItems();
	}
	@GetMapping("getitembyid/{id}")
	public MenuItems getItemById(@PathVariable int id) {
		return repo.getItemById(id);
	}
	
//	@PostMapping("/menu")
//    public ModelAndView showMenuPage() {
//		ModelAndView modelAndView = new ModelAndView();
//	    modelAndView.setViewName("editmenu");
//	    return modelAndView;
//    }
}
