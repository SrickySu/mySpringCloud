package com.surichard.myService1.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.surichard.myService1.entity.TimeZoneEntity;

@Mapper
public interface TimeZoneEntityMapper {
    int deleteByPrimaryKey(Integer timeZoneId);

    int insert(TimeZoneEntity record);

    int insertSelective(TimeZoneEntity record);

    TimeZoneEntity selectByPrimaryKey(Integer timeZoneId);

    int updateByPrimaryKeySelective(TimeZoneEntity record);

    int updateByPrimaryKey(TimeZoneEntity record);
}