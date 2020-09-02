package opensource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringCloud Alibaba Nacos配置中心使用Demo
 *
 * @author WuWenTao
 * @version 1.0
 * @date 2020/9/2 14:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BuscienService04Appl {

    public static void main(String[] args) {
        SpringApplication.run(BuscienService04Appl.class, args);
    }
}

@RestController
@RequestMapping("/config/")
@RefreshScope
class NacosConfigPropertyController{

    @Value("${configinfo:defualt}")
    private String configinfo;

    @GetMapping("configinfo")
    public String configinfo(){
        return this.configinfo;
    }
}
