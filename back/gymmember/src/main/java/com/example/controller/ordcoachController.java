package com.example.controller;

import com.example.dao.ordcoachDao;
import com.example.model.ordcoach;
import com.example.model.purcurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordcoach")
public class ordcoachController {

    @Autowired
    private ordcoachDao ordcDao;

    //保存新订单
    @PostMapping("/save")
    public int save(@RequestBody ordcoach ordc){
        return ordcDao.insert(ordc);
    }
    //查询指定用户的订单
    @GetMapping("/{id}")
    public List<ordcoach> getAll(@PathVariable String id){
        List<ordcoach> ordcoachList = ordcDao.findWhoById(id);
        return ordcoachList;
    }

    //删除
    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id){
        return ordcDao.delete(id);
    }


}
