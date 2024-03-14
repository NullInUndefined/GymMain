package com.example.dao;

import com.example.model.member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface memberDao {
    //add   所有的int返回类型都返回的是执行成功的次数
    @Insert("insert into member(cardnum,name,idnum,discount,phnum,type,allmoney,status,comment) values (#{cardnum},#{name},#{idnum},#{discount},#{phnum},#{type},#{allmoney},#{status},#{comment})")
    int insert(member mem);

    //delete
    @Delete("delete from member where cardnum=#{cardnum}")
    int delete(@Param("cardnum") String id);

    //show
    @Select("select * from member where cardnum=#{cardnum}")
    member findMembersById(@Param("cardnum") String cardnum);

    //showAll
    @Select("select * from member")
    List<member> findAllMembers();
    //update
    @Update("update member set name=#{name},idnum=#{idnum},discount=#{discount},phnum=#{phnum},type=#{type},allmoney=#{allmoney},status=#{status},comment=#{comment} where cardnum=#{cardnum}" )
    int update(member mem);

}
