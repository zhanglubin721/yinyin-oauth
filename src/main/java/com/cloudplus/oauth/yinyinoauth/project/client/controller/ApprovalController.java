package com.cloudplus.oauth.yinyinoauth.project.client.controller;

import com.cloudplus.oauth.yinyinoauth.project.client.domain.Client;
import com.cloudplus.oauth.yinyinoauth.project.client.service.ClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author zhanglubin
 * @date 2021/2/2
 */
@Controller
@SessionAttributes("authorizationRequest")
public class ApprovalController {

    @Autowired
    private ClientServer clientServer;

    @RequestMapping("/custom/confirm_access")
    public String getAccessConfirmation(Map<String, Object> param, HttpServletRequest request, Model model) throws Exception {

        AuthorizationRequest authorizationRequest = (AuthorizationRequest) param.get("authorizationRequest");
        if (authorizationRequest==null){
            return "redirect:login";
        }
        String clientId = authorizationRequest.getClientId();
        model.addAttribute("scopes",authorizationRequest.getScope());
        model.addAttribute("clientId",clientId);
        //根据clientId查询客户端信息，并返回前端页面客户端名称、客户端图标等信息
        Client client = new Client();
        client.setClientId(clientId);
        List<Client> clientData = clientServer.getClientData(client);
        String clientImageName = "";
        String clientName = "";
        if (clientData.size() > 0) {
            clientImageName = clientData.get(0).getClientImage();
            clientName = clientData.get(0).getClientName();
        }
        model.addAttribute("clientImageName","'" + clientImageName + "'");
        model.addAttribute("clientName",clientName);
        return "oauth_approval";
    }

}
