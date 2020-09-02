package com.opensource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringCloud Alibaba 服务发现 Feign进行消费服务
 *
 * @author WuWenTao
 * @version 1.0
 * @date 2020/9/2 14:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BuscienService03Appl {

    public static void main(String[] args) {
        SpringApplication.run(BuscienService03Appl.class, args);
    }
}

@FeignClient("buscien-service-01-app")
interface BuscienDemo1Feign {

    @GetMapping("/buscien1/sayHello")
    public String sayHello(@RequestParam(name = "name") String name);
}

@RestController
@RequestMapping("/buscien3/")
class FeignConsumerController {

    @Autowired
    private BuscienDemo1Feign buscienDemo1Feign;

    @GetMapping("/consumer")
    public String consumer(@RequestParam String name) {
        return buscienDemo1Feign.sayHello(name);
    }

}
