package com.surichard.myService1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyService1Controller {

	@GetMapping(value = "/information")
	public String getInformation() {
		return "Good Job! This is my service1.";
	}
}
