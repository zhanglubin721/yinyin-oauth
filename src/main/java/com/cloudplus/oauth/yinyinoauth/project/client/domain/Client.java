package com.cloudplus.oauth.yinyinoauth.project.client.domain;

import java.util.Date;
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
    //范围（默认为all）
    String scope;
    //客户端图标
    String clientImage;
    //可跳转的路径集合 格式：（uri1,uri2）
    String uri;
    //支持的认证模式集合 格式：（1,2,3,4,5） 1：授权码模式，2：密码模式，3：客户端模式，4：隐式授权，5：刷新Tocken
    String authorizedGrantType;
    //创建时间
    Date createTime;

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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getClientImage() {
        return clientImage;
    }

    public void setClientImage(String clientImage) {
        this.clientImage = clientImage;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAuthorizedGrantType() {
        return authorizedGrantType;
    }

    public void setAuthorizedGrantType(String authorizedGrantType) {
        this.authorizedGrantType = authorizedGrantType;
    }

    public Client() {
    }

    public Client(String clientName, String clientId, String clientSecret, String scope, String clientImage, String uri, String authorizedGrantType, Date createTime) {
        this.clientName = clientName;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.clientImage = clientImage;
        this.uri = uri;
        this.authorizedGrantType = authorizedGrantType;
        this.createTime = createTime;
    }
}
