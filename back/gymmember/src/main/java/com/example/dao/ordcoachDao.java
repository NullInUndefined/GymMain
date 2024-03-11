package com.example.dao;

import com.example.model.ordcoach;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ordcoachDao {
    //提交购买信息
    @Insert("insert into ordercoach (orderid,cardnum,coachid,costtime,comment,costmoney) values (#{orderid},#{cardnum},#{coachid},current_timestamp,#{comment},#{costmoney})")
    int insert(ordcoach ordc);
    //查询指定用户的订单
    @Select("select * from ordercoach where cardnum=#{cardnum}")
    List<ordcoach> findWhoById(@Param("cardnum") String cardnum);
    //删除订单
    @Delete("delete from ordercoach where orderid=#{orderid}")
    int delete(@Param("orderid") String orderid);

    //查询所有订单
    @Select("select * from ordercoach ")
    List<ordcoach> findAll();
}
