package com.cloudplus.oauth.yinyinoauth.project.client.domain;

import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/1
 */
public class Client {
    String clientName;
    //客户端id
    String clientId;
    //客户端密码
    String clientSecret;
    //支持的认证模式
    List<AuthorizedGrantType> authorizedGrantTypes;
    //支持的重定向地址
    List<RedirectUri> redirectUris;
    //范围（默认为all）
    String scope;
    //客户端图标
    String clientImage;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public List<AuthorizedGrantType> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(List<AuthorizedGrantType> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public List<RedirectUri> getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(List<RedirectUri> redirectUris) {
        this.redirectUris = redirectUris;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Client(String clientName, String clientId, String clientSecret, List<AuthorizedGrantType> authorizedGrantTypes, List<RedirectUri> redirectUris, String scope, String clientImage) {
        this.clientName = clientName;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.redirectUris = redirectUris;
        this.scope = scope;
        this.clientImage = clientImage;
    }

    public Client() {
    }

    public String getClientImage() {
        return clientImage;
    }

    public void setClientImage(String clientImage) {
        this.clientImage = clientImage;
    }
}
