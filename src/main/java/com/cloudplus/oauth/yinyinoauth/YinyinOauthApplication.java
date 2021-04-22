package com.cloudplus.oauth.yinyinoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()//排除自动配置
public class YinyinOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(YinyinOauthApplication.class, args);
        System.out.println("-------------认证服务启动成功----------------");
    }

}
