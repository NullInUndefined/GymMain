package com.example.dao;

import com.example.model.coach;
import com.example.model.member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface coachDao {
    @Insert("insert into coach(coachid,name,gender,age,goodat,selfintro,chargestandard,phnum) values (#{coachid},#{name},#{gender},#{age},#{goodat},#{selfintro},#{chargestandard},#{phnum})")
    int insert(coach coa);

    //delete
    @Delete("delete from coach where coachid=#{coachid}")
    int delete(@Param("coachid") String id);

    //show
    @Select("select * from coach where coachid=#{coachid}")
    coach findCoachById(@Param("coachid") String coachid);

    //showAll
    @Select("select * from coach")
    List<coach> findAllCoaches();

    //update
    @Update("update coach set name=#{name},gender=#{gender},age=#{age},goodat=#{goodat},selfintro=#{selfintro},chargestandard=#{chargestandard},phnum=#{phnum} where coachid=#{coachid}")
    int update(coach coa);
}
