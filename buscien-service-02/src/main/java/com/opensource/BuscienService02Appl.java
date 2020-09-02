package com.opensource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * SpringCloud Alibaba服务发现
 *
 * @author WuWenTao
 * @version 1.0
 * @date 2020/9/2 11:38
 */
@EnableDiscoveryClient
@SpringBootApplication
@Configuration
public class BuscienService02Appl {
    public static void main(String[] args) {
        SpringApplication.run(BuscienService02Appl.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

@RestController
@RequestMapping("/buscien2/")
class ConsumerController {

    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("consumer")
    public String consumer(@RequestParam String name) {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("buscien-service-01-app");
        String url = "http://" + serviceInstance.getServiceId() + ":" + serviceInstance.getPort() + "/buscien1/sayHello?name=" + name;
        log.info(url);
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
