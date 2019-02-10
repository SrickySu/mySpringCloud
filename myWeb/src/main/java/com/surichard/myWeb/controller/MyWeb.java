package com.surichard.myWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyWeb {

	@RequestMapping(value = "/information")
	public String getInformation(Model model) {
		model.addAttribute("title", "myTitle");
		model.addAttribute("myName", "surichard");
		return "/home";
	}
}
