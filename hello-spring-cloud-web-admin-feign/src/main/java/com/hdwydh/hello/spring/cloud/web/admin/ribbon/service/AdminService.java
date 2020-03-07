package com.hdwydh.hello.spring.cloud.web.admin.ribbon.service;

import com.hdwydh.hello.spring.cloud.web.admin.ribbon.service.hystrix.AdminHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//服务提供者
//feign 集成了 ribbon 所以实际开发中选择feign
@FeignClient(value = "hello-spring-cloud-service-admin",fallback = AdminHystrix.class)
public interface AdminService {


    @GetMapping(value = "hi")
    String sayHi(@RequestParam("message") String message);
}
