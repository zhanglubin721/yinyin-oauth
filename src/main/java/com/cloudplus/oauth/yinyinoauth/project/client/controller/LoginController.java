package com.cloudplus.oauth.yinyinoauth.project.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhanglubin
 * @date 2021/1/29
 */
@Controller
@RequestMapping("/oauth")
public class LoginController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
