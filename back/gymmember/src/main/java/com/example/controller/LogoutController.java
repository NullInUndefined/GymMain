package com.example.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // 获取当前的Subject
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            // 执行退出操作
            currentUser.logout();
            // 可以在这里添加任何自定义逻辑，比如记录日志等
            return "You have been successfully logged out.";
        } else {
            return "No user is currently logged in.";
        }
    }
}
