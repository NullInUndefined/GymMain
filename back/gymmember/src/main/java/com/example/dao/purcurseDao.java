package com.example.dao;

import com.example.model.ordcoach;
import com.example.model.purcurse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface purcurseDao {


    //提交购买信息
    @Insert("insert into purchasecurse (orderid,cardnum,curseid,costtime,comment,costmoney) values (#{orderid},#{cardnum},#{curseid},current_timestamp,#{comment},#{costmoney})")
    int insert(purcurse purc);
    //查询指定用户的订单
    @Select("select * from purchasecurse where cardnum=#{cardnum}")
    List<purcurse> findWhoById(@Param("cardnum") String cardnum);

    //查询所有用户订单
    @Select("select * from purchasecurse ")
    List<purcurse> findAll();

    //删除订单
    @Delete("delete from purchasecurse where cardnum=#{cardnum}")
    int delete(@Param("cardnum") String cardnum);

    //减少余量
    @Update("update curse set leftcurse = leftcurse-1 where curseid=#{curseid}")
    int updateAdd(@Param("curseid") String curseid);

    //增加余量,小伙伴对不起产能不足，没有实现这个方法，因为删除订单时获取的是订单号，而这个需要课程号，实在懒得改了以后再说
    @Update("update curse set leftcurse = leftcurse+1 where curseid=#{curseid}")
    int updateDelete(@Param("curseid") String curseid);
}
