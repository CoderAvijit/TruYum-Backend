package com.truYum.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.truYum.app.Repository.*;
@RestController
@RequestMapping("/login")
@ResponseBody
public class loginController {
	@Autowired
	private loginRepo repo;
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/logincontroller")
	public ModelAndView doLogin(@RequestParam String role,@RequestParam String email,
	        @RequestParam String password) {
		String redirectUrl = repo.doLogin(role,email, password);
		 if (redirectUrl.equals("/addmenu.html")) {
	            // If it's an admin login, redirect to the admin menu HTML page in the static directory
			 ModelAndView modelAndView = new ModelAndView();
			    modelAndView.setViewName("addmenu.html");
			    System.out.println(modelAndView);
			    return modelAndView;
	        } else if(redirectUrl.equalsIgnoreCase("adminpage")) {
	        	ModelAndView modelAndView = new ModelAndView();
			    modelAndView.setViewName("editmenu");
			    return modelAndView;
	        }
	        	else {
	            // Handle other redirects or error messages as needed
	        	ModelAndView modelAndView = new ModelAndView();
			    modelAndView.setViewName("ErrorPage");
			    return modelAndView;
	        }
	}
}
