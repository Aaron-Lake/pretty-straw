package cn.tedu.straw.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableZuulProxy
@EnableWebSecurity
public class StrawGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrawGatewayApplication.class, args);
    }

}
