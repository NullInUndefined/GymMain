package com.example.service.serviceImpl;

import com.example.dao.curseDao;
import com.example.model.curse;
import com.example.service.curseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class curseServiceImpl implements curseService {

    @Autowired
    private curseDao curDao;

    @Override
    public List<curse> findAll() {
        return curDao.findAllCurses();
    }

    @Override
    public curse findone(String id) {
        return curDao.findCurseById(id);
    }

    @Override
    public int insert(curse cur) {
        return curDao.insert(cur);
    }

    @Override
    public int update(curse cur) {
        return curDao.update(cur);
    }

    @Override
    public int delete(String id) {
        return curDao.delete(id);
    }
}
