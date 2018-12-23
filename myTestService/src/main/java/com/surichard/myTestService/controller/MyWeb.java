package com.surichard.myTestService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWeb {

	@GetMapping(value = "/information")
	public String getInformation() {
		return "Good Job!";
	}
}
