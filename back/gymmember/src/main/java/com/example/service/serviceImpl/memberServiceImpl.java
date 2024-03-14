package com.example.service.serviceImpl;

import com.example.dao.memberDao;
import com.example.model.member;
import com.example.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class memberServiceImpl implements memberService {

    @Autowired
    private memberDao memDao;

    @Override
    public List<member> findAll() {
        return memDao.findAllMembers();
    }

    @Override
    public member fineone(String id) {
        return memDao.findMembersById(id);
    }

    @Override
    public int insert(member mem) {
        return memDao.insert(mem);
    }

    @Override
    public int update(member mem) {
        return memDao.update(mem);
    }

    @Override
    public int delete(String id) {
        return memDao.delete(id);
    }

}
