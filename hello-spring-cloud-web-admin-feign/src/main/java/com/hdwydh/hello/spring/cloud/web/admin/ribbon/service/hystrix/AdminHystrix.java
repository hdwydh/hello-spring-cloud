package com.hdwydh.hello.spring.cloud.web.admin.ribbon.service.hystrix;

import com.hdwydh.hello.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminHystrix implements AdminService {
    @Override
    public String sayHi(String message) {
        return "Hi,your message is : \""+message+"\" but request error.";
    }
}
