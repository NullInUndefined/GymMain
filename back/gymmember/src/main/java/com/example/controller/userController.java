package com.example.controller;

import com.example.dao.userDao;
import com.example.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/loginAndRegister")
public class userController {
    @Autowired
    private userDao usDao;

    //注册时确定用户名是否重复
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String select(@RequestBody user us) {
        System.out.println(us.getAccount());
        user result = usDao.selectUserAccount(us.getAccount());
        System.out.println(result);
        if (result == null) {
            return "0";//等于0时账号不重复，可以注册
        }
        return "1";//账号重复 不能注册
    }

    //正式注册账号到数据库中
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody user us) {
        System.out.println(us);
        usDao.insert(us);
        return "1";
    }

    //登陆时校验账号密码
    @RequestMapping(value = "/selectUserName", method = RequestMethod.POST)
    public String selectUserAccount(@RequestBody user us) {
        user getu=us;
        if(getu.getAccount().startsWith("G"))
            return "Admin";
        else return "Member";

    }
//        String userAccount = us.getAccount();
//        String userPassword = us.getPasswd();
//        System.out.println(userAccount + userPassword);
//
//        String result = "-1";
//
//        //用户不存在
//        if (usDao.selectUserAccount(userAccount) == null) {
//            result = "0";
//            //            return "用户不存在";
//            return result;
//        }
//
//            //用户存在，但密码输入错误
//        else if(parseInt(usDao.selectUserPassword(userPassword))<=0 ){
//            result = "1";
//            //            return "账号或密码输入错误";
//            return result;
//
//
//
//        }else if(parseInt(usDao.selectUserPassword(userAccount))>0) {
//            result = "2";
////            return "成功登录";
//            return result;
//        }
//        return result;//这种情况就是寄了 返回了个-1
//    }
}
