package com.example.service;

import com.example.model.member;

import java.util.List;

public interface memberService {
    //all
    List<member> findAll();
    //one
    member fineone(String id);

    //insert
    int insert(member mem);

    //update
    int update(member mem);

    //delete
    int delete(String id);

}
