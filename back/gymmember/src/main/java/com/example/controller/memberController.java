package com.example.controller;

import com.example.model.member;
import com.example.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/AdminMem")
public class memberController {

    @Autowired
    private memberService memService;

    @PostMapping
    public int save(@RequestBody member mem) {
        return memService.insert(mem);
    }

    @PutMapping
    public int update(@RequestBody member mem) {
        return memService.update(mem);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        return memService.delete(id);
    }

    @GetMapping("/{id}")
    public member getById(@PathVariable String id) {
        return memService.fineone(id);
    }

    @GetMapping("/getAll")
    public List<member> getAll(){
        List<member> memlist = memService.findAll();

        return memlist;
    }



//    下面是使用thymeleaf的写法
//    @RequestMapping(value = "/" )
//    public String findByUserAge(Model model) {
//        System.out.println("查询所有数据:");
//        List<member> mem = memService.findAll();
//        //传过去的是S：里的名字
//        model.addAttribute("member",mem);
//        return "index";
//    }
//
//    //删除数据
//    @RequestMapping("/delete/{id}")
//    public String delete(@PathVariable String id, HttpServletResponse servletResponse) throws IOException {
//        int count =memService.delete(id);
//        if(count==1){
//            servletResponse.sendRedirect("/list");
//        }
//        return "error";
//    }
}
