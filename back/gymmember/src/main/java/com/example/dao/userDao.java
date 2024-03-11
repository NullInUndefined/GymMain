package com.example.dao;

import com.example.model.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userDao {

    //添加新账号
    @Insert("insert into user(account,passwd,type) values (#{account},#{passwd},#{type})")
    int insert(user us);

    @Select("select * from user where account = #{account}")
    user selectUserPassword(@Param("account") String account);

    @Select("select * from user where account = #{account}")
    user selectUserAccount(@Param("account") String account);
}
