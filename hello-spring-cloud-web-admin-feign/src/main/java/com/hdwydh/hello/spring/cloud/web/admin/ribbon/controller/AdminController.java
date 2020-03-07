package com.hdwydh.hello.spring.cloud.web.admin.ribbon.controller;

import com.hdwydh.hello.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {


    @Autowired
    private AdminService adminService;



    @GetMapping(value = "hi")
    public String sayHi(String message){
        return adminService.sayHi(message);
    }
}
