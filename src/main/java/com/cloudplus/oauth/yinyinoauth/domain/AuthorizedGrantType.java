package com.cloudplus.oauth.yinyinoauth.domain;

/**
 * @author zhanglubin
 * @date 2021/2/2
 */
public class AuthorizedGrantType {

    private int authorizedGrantTypeId;
    private String authorizedGrantType;

    public int getAuthorizedGrantTypeId() {
        return authorizedGrantTypeId;
    }

    public void setAuthorizedGrantTypeId(int authorizedGrantTypeId) {
        this.authorizedGrantTypeId = authorizedGrantTypeId;
    }

    public String getAuthorizedGrantType() {
        return authorizedGrantType;
    }

    public void setAuthorizedGrantType(String authorizedGrantType) {
        this.authorizedGrantType = authorizedGrantType;
    }

    public AuthorizedGrantType(int authorizedGrantTypeId, String authorizedGrantType) {
        this.authorizedGrantTypeId = authorizedGrantTypeId;
        this.authorizedGrantType = authorizedGrantType;
    }

    public AuthorizedGrantType() {
    }
}
