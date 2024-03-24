package com.truYum.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.truYum.app.Repository.*;
@RestController
@RequestMapping("/example")
@ResponseBody
public class exampleController {
	@Autowired
	private loginRepo repo;
//	@CrossOrigin(origins = "http://localhost:3000")
//	@CrossOrigin("*")
	@GetMapping("/check")
	public String checkThat() {
		return "working";
	}
}
