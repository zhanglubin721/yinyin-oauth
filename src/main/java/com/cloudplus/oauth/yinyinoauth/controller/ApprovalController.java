package com.cloudplus.oauth.yinyinoauth.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhanglubin
 * @date 2021/2/2
 */
@Controller
@SessionAttributes("authorizationRequest")
public class ApprovalController {

    @RequestMapping("/custom/confirm_access")
    public String getAccessConfirmation(Map<String, Object> param, HttpServletRequest request, Model model) throws Exception {

        AuthorizationRequest authorizationRequest = (AuthorizationRequest) param.get("authorizationRequest");
        if (authorizationRequest==null){
            return "redirect:login";
        }
        String clientId = authorizationRequest.getClientId();
        model.addAttribute("scopes",authorizationRequest.getScope());
        model.addAttribute("clientId",clientId);
        model.addAttribute("clientImageName","'" + clientId + "'");
        //根据clientId查询客户端信息，并返回前端页面客户端名称、客户端图标等信息
        //TODO
        return "oauth_approval";
    }

}
