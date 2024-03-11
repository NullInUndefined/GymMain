package com.example.service;

import com.example.model.coach;

import java.util.List;

public interface coachService {

    List<coach> findAll();

    coach findone(String id);

    int insert(coach coa);

    int update(coach coa);

    int delete(String id);

    coach redisfindone(String id);

    int redisupdate (coach coa);

}
