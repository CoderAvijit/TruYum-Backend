package com.truYum.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.truYum.app.Repository.*;
import com.truYum.app.response.*;
import com.truYum.app.persitant.*;
@RestController
@RequestMapping("/login")
@ResponseBody
public class loginController {
	@Autowired
	private loginRepo repo;
	@CrossOrigin(origins = "*")
	@PostMapping("/logincontroller")
	public ModelAndView doLogin(@RequestParam String role,@RequestParam String email,
	        @RequestParam String password) {
		String redirectUrl = repo.doLogin(role,email, password);
		 if (redirectUrl.equals("/addmenu.html")) {
	            // If it's an admin login, redirect to the admin menu HTML page in the static directory
			ModelAndView mv = new ModelAndView("addmenu.html");
			return mv;
	        } else if(redirectUrl.equalsIgnoreCase("adminpage")) {
	        	ModelAndView mv = new ModelAndView("editmenu.html");
				return mv;
	        }
	        	else {
	            // Handle other redirects or error messages as needed
	        		ModelAndView mv = new ModelAndView("ErrorPage.html");
	    			return mv;
	        }
	}
}
