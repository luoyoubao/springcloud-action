package org.xunmeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@EnableEurekaClient
@RestController

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/say")
    @ResponseBody
    String home() {
        System.err.println("hello world===>");
        return "Hello World==>" + System.currentTimeMillis();
    }

    @RequestMapping("/hystrix")
    @ResponseBody
    String check() throws Exception {
        int random = new Random().nextInt(10);
        System.err.println("random ===>" + random);
        if (random % 2 != 0) {
            throw new Exception("service exception");
        }
        return "succeed";
    }
}
