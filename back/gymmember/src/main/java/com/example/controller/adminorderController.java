package com.example.controller;

import com.example.dao.adminorderDao;
import com.example.dao.ordcoachDao;
import com.example.dao.purcurseDao;
import com.example.model.adminorder;
import com.example.model.ordcoach;
import com.example.model.purcurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adminorder")
public class adminorderController {
    @Autowired
    private ordcoachDao adoDao;

    @Autowired
    private purcurseDao purDao;

    @GetMapping("/GetAllCoa")
    public List<ordcoach> getAdminOrderCoa(){
        List<ordcoach> all1=adoDao.findAll();
        System.out.println(all1);
        return all1;
    }

    @GetMapping("/GetAllCur")
    public List<purcurse> getAdminOrderCur(){
        List<purcurse> all1=purDao.findAll();
        System.out.println(all1);
        return all1;
    }
}
