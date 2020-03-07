package com.hdwydh.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {


    @Autowired
    private RestTemplate restTemplate;


    //熔断后返回 hiError 方法的结果
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message){
        //直接使用 服务提供者的名称 加接口
        return restTemplate.getForObject("http://hello-spring-cloud-service-admin/hi?message="+message,String.class);
    }

    //这叫熔断方法
    public String hiError(String message){
        return "Hi,your message is : \""+message+"\" but request error.";

    }
}
