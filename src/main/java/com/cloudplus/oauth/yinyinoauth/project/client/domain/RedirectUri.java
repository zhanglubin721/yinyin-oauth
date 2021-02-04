package com.cloudplus.oauth.yinyinoauth.project.client.domain;

/**
 * @author zhanglubin
 * @date 2021/2/1
 */
public class RedirectUri {

    private Long uriId;
    private String uriClientId;
    private String uri;

    public Long getUriId() {
        return uriId;
    }

    public void setUriId(Long uriId) {
        this.uriId = uriId;
    }

    public String getUriClientId() {
        return uriClientId;
    }

    public void setUriClientId(String uriClientId) {
        this.uriClientId = uriClientId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public RedirectUri(Long uriId, String uriClientId, String uri) {
        this.uriId = uriId;
        this.uriClientId = uriClientId;
        this.uri = uri;
    }

    public RedirectUri() {
    }
}
