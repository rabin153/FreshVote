package com.freshvotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// The purpose of the controllers is to intercept any request or http request
//
@Controller
public class DashboardController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootView() {
		return "index";
	}

	@GetMapping("/dashboard")
	public String dashboardIndez() {
		System.out.println("Inside the login ");
		return "dashboard";
	}

//	@PostMapping("/dashboard")
//	public String dashboard() {
//		return "dashboard";
//	}

}
