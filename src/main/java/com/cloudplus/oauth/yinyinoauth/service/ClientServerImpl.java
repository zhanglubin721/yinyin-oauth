package com.cloudplus.oauth.yinyinoauth.service;

import com.cloudplus.oauth.yinyinoauth.domain.AuthorizedGrantType;
import com.cloudplus.oauth.yinyinoauth.domain.Client;
import com.cloudplus.oauth.yinyinoauth.domain.RedirectUri;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author zhanglubin
 * @date 2021/2/3
 */
@Service
public class ClientServerImpl implements ClientServer{

    /**
     * 制作动态初始化登录所需客户端信息配置的假数据，正常情况下需要查询数据库
     * @return
     */
    @Override
    public ArrayList<Client> getClientData() {
        ArrayList<Client> clients = new ArrayList<>();
        Client client1 = new Client();
        client1.setClientId("client1");
        client1.setClientName("client1");
        client1.setClientSecret("client1");
        client1.setScope("all");
        client1.setClientImage("client1");
        ArrayList<RedirectUri> redirectUris = new ArrayList<>();
        RedirectUri redirectUri = new RedirectUri();
        redirectUri.setUri("http://www.baidu.com");
        RedirectUri redirectUri1 = new RedirectUri();
        redirectUri1.setUri("http://www.jd.com");
        redirectUris.add(redirectUri);
        redirectUris.add(redirectUri1);
        client1.setRedirectUris(redirectUris);
        ArrayList<AuthorizedGrantType> authorizedGrantTypes = new ArrayList<>();
        AuthorizedGrantType authorizedGrantType1 = new AuthorizedGrantType();
        authorizedGrantType1.setAuthorizedGrantType("authorization_code");
        AuthorizedGrantType authorizedGrantType2 = new AuthorizedGrantType();
        authorizedGrantType2.setAuthorizedGrantType("password");
        AuthorizedGrantType authorizedGrantType3 = new AuthorizedGrantType();
        authorizedGrantType3.setAuthorizedGrantType("client_credentials");
        AuthorizedGrantType authorizedGrantType4 = new AuthorizedGrantType();
        authorizedGrantType4.setAuthorizedGrantType("implicit");
        AuthorizedGrantType authorizedGrantType5 = new AuthorizedGrantType();
        authorizedGrantType5.setAuthorizedGrantType("refresh_token");
        authorizedGrantTypes.add(authorizedGrantType1);
        authorizedGrantTypes.add(authorizedGrantType2);
        authorizedGrantTypes.add(authorizedGrantType3);
        authorizedGrantTypes.add(authorizedGrantType4);
        authorizedGrantTypes.add(authorizedGrantType5);
        client1.setAuthorizedGrantTypes(authorizedGrantTypes);
        clients.add(client1);

        Client client2 = new Client();
        client2.setClientId("client2");
        client2.setClientName("client2");
        client2.setClientSecret("client2");
        client2.setScope("all");
        client2.setClientImage("client1");
        ArrayList<RedirectUri> redirectUris2 = new ArrayList<>();
        RedirectUri redirectUri2 = new RedirectUri();
        redirectUri2.setUri("http://www.jd.com");
        RedirectUri redirectUri3 = new RedirectUri();
        redirectUri3.setUri("http://www.baidu.com");
        redirectUris2.add(redirectUri2);
        redirectUris2.add(redirectUri3);
        client2.setRedirectUris(redirectUris2);
        ArrayList<AuthorizedGrantType> authorizedGrantTypes2 = new ArrayList<>();
        authorizedGrantTypes2.add(authorizedGrantType1);
        authorizedGrantTypes2.add(authorizedGrantType2);
        authorizedGrantTypes2.add(authorizedGrantType3);
        authorizedGrantTypes2.add(authorizedGrantType4);
        authorizedGrantTypes2.add(authorizedGrantType5);
        client2.setAuthorizedGrantTypes(authorizedGrantTypes2);
        clients.add(client2);

        return clients;
    }
}
