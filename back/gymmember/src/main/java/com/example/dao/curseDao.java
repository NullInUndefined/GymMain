package com.example.dao;

import com.example.model.coach;
import com.example.model.curse;
import com.example.model.member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface curseDao {
    @Insert("insert into curse(curseid,name,intro,chargestandard,maxnum,starttime,leftcurse) values (#{curseid},#{name},#{intro},#{chargestandard},#{maxnum},#{starttime},#{leftcurse})")
    int insert(curse cur);

    //delete
    @Delete("delete from curse where curseid=#{curseid}")
    int delete(@Param("curseid") String id);

    //show
    @Select("select * from curse where curseid=#{curseid}")
    curse findCurseById(@Param("curseid") String curseid);

    //showAll
    @Select("select * from curse")
    List<curse> findAllCurses();

    //update
    @Update("update curse set name=#{name},intro=#{intro},chargestandard=#{chargestandard},maxnum=#{maxnum},starttime=#{starttime},leftcurse=#{leftcurse} where curseid=#{curseid}")
    int update(curse cur);
}
