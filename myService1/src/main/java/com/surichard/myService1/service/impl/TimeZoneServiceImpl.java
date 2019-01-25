package com.surichard.myService1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surichard.myService1.entity.TimeZoneEntity;
import com.surichard.myService1.mapper.TimeZoneEntityMapper;
import com.surichard.myService1.service.TimeZoneService;

@Service
@Transactional
public class TimeZoneServiceImpl implements TimeZoneService {
	
	@Autowired
	private TimeZoneEntityMapper mapper;

	@Override
	public TimeZoneEntity getTimeZoneById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

}
