package com.example.controller;

import com.example.model.coach;
import com.example.model.curse;
import com.example.service.coachService;
import com.example.service.curseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdminCoa")
public class coachController {

    @Autowired
    private coachService coaService;

    @PostMapping
    public int save(@RequestBody coach coa) {
        return coaService.insert(coa);
    }

    @PutMapping
    public int update(@RequestBody coach coa) {
        return coaService.redisupdate(coa);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        return coaService.delete(id);
    }

    @GetMapping("/{id}")
    public coach getById(@PathVariable String id) {
        return coaService.redisfindone(id);
    }

    @GetMapping("/getAll")
    public List<coach> getAll(){
        List<coach> coalist = coaService.findAll();
        return coalist;
    }
}
