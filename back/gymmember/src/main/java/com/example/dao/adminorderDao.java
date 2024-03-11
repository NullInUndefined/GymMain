package com.example.dao;

import com.example.model.adminorder;
import com.example.model.member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface adminorderDao {
    //多表查询啦,这个是查课程
    @Select("select orderid,purchasecurse.cardnum,costtime,costmoney,allmoney,purchasecurse.comment from purchasecurse,member where purchasecurse.cardnum=member.cardnum")
    List<adminorder> findAllCurses();

    @Select("select orderid,ordercoach.cardnum,costtime,costmoney,allmoney,ordercoach.comment from ordercoach,member where ordercoach.cardnum=member.cardnum")
    List<adminorder> findAllCoaches();
}
