package com.opensource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * SpringCloud Alibaba Nacos 服务注册
 *
 * @author WuWenTao
 * @version 1.0
 * @date 2020/9/2 11:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BuscienService01Appl {

    public static void main(String[] args) {
        SpringApplication.run(BuscienService01Appl.class, args);
    }
}


@RestController
@RequestMapping("/buscien1/")
class BuscienDemo1Controller {

    private static final Logger log = LoggerFactory.getLogger(BuscienDemo1Controller.class);

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        log.info("BuscienDemo1Controller sayHello name:{}", name);
        return "hello " + name;
    }

}
