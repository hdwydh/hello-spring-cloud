package com.hdwydh.hello.spring.cloud.web.admin.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced  //负载均衡访问功能 服务，xxx cloud-service-admin 通过 8762 8763 启动多个 服务 ，web 这边 模拟负载均衡请求
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
