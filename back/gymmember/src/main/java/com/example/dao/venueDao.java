package com.example.dao;

import com.example.model.venue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface venueDao {
    @Insert("INSERT INTO venue (roomid, area, note, courseid) VALUES (#{roomid}, #{area}, #{note}, #{courseid})")
    void insert(venue room);

    @Update("UPDATE rooms SET area = #{area}, note = #{note}, courseid = #{courseid} WHERE roomid = #{roomid}")
    void update(venue room);

    @Delete("DELETE FROM venue WHERE roomid = #{roomid}")
    void delete(Integer roomid);

    @Select("SELECT * FROM venue WHERE roomid = #{roomid}")
    venue findById(Integer roomid);

    @Select("SELECT venue.roomid, venue.area, venue.note, venue.courseid, curse.name FROM venue LEFT JOIN curse ON venue.courseid = curse.curseid;")
    List<venue> findAll();
}
