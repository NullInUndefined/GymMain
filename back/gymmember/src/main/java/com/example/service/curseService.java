package com.example.service;

import com.example.model.curse;

import java.util.List;

public interface curseService {

    List<curse> findAll();

    curse findone(String id);

    int insert(curse cur);

    int update(curse cur);

    int delete(String id);
}
