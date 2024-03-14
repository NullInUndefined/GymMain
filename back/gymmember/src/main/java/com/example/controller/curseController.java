package com.example.controller;


import com.example.model.curse;
import com.example.model.member;
import com.example.service.curseService;
import com.example.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdminCur")
public class curseController {
    @Autowired
    private curseService curService;

    @PostMapping
    public int save(@RequestBody curse cur) {
        return curService.insert(cur);
    }

    @PutMapping
    public int update(@RequestBody curse cur) {
        return curService.update(cur);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        return curService.delete(id);
    }

    @GetMapping("/{id}")
    public curse getById(@PathVariable String id) {
        return curService.findone(id);
    }

    @GetMapping("/getAll")
    public List<curse> getAll(){
        List<curse> curlist = curService.findAll();
        return curlist;
    }
}
