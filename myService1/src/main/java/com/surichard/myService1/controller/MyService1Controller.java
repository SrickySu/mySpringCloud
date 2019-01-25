package com.surichard.myService1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surichard.myService1.entity.TimeZoneEntity;
import com.surichard.myService1.service.TimeZoneService;

@RestController
public class MyService1Controller {

	private static final Logger logger = LoggerFactory.getLogger(MyService1Controller.class);

	@Autowired
	private TimeZoneService timeZoneService;

	@Value(value = "${spring.application.name}")
	private String applicationName;

	@GetMapping(value = "/information")
	public String getInformation(@RequestParam(name = "id", required = false) Integer id) {
		logger.info("applicationName is {}", applicationName);
		TimeZoneEntity item = timeZoneService.getTimeZoneById(id);
		item = item == null ? new TimeZoneEntity() : item;
		logger.info("time zone is {}", item);
		return "Good Job! This is my service1. TimeZone " + id + " is " + item.getUseLeapSeconds();
	}
}
