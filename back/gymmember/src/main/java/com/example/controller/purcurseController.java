package com.example.controller;

import com.example.dao.purcurseDao;
import com.example.model.purcurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purcurse")
public class purcurseController {

    @Autowired
    private purcurseDao purcDao;
    //保存新订单
    @PostMapping("/save")
    public int save(@RequestBody purcurse purc){
        purcDao.updateAdd(purc.getCurseid());
        return purcDao.insert(purc);
    }
    //查询指定用户的订单
    @GetMapping("/{id}")
    public List<purcurse> getAll(@PathVariable String id){
        List<purcurse> purcurseList = purcDao.findWhoById(id);
        return purcurseList;
    }

    //删除
    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id){
        return purcDao.delete(id);
    }

}
