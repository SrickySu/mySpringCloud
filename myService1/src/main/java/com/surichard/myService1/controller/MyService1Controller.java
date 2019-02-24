package com.surichard.myService1.controller;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.surichard.myCommon.web.response.BaseResponse;
import com.surichard.myCommon.web.result.ResultMessage;
import com.surichard.myService1.entity.TimeZoneEntity;
import com.surichard.myService1.service.QueueTestService;
import com.surichard.myService1.service.TimeZoneService;

@RestController
public class MyService1Controller {

	private static final Logger logger = LoggerFactory.getLogger(MyService1Controller.class);

	@Autowired
	private TimeZoneService timeZoneService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private QueueTestService queueTestService;
	
	@Value(value = "${spring.application.name}")
	private String applicationName;

	@GetMapping(value = "/information")
	public BaseResponse<TimeZoneEntity> getInformation(@RequestParam(name = "id", required = false) Integer id) {
		logger.info("applicationName is {}", applicationName);
		TimeZoneEntity item = timeZoneService.getTimeZoneById(id);
		item = item == null ? new TimeZoneEntity() : item;
		logger.info("time zone is {}", item);
		return BaseResponse.succeed(item);
	}

	@GetMapping(value = "/setRedis")
	public BaseResponse<String> setRedis(@RequestParam(name = "myName", required = false) String myName) {
		stringRedisTemplate.opsForValue().set("myName", myName, 60, TimeUnit.SECONDS);
		return BaseResponse.succeed(ResultMessage.SUCCESS);
	}

	@GetMapping(value = "/getRedis")
	public BaseResponse<String> getRedis() {
		String result = stringRedisTemplate.opsForValue().get("myName");
		return BaseResponse.succeed(result);
	}

	@GetMapping(value = "/sendMessage")
	public BaseResponse<String> sendMessage(@RequestParam(name = "message", required = true) String message) {
		queueTestService.sendMessage(message);
		return BaseResponse.succeed(ResultMessage.SUCCESS);
	}

}
