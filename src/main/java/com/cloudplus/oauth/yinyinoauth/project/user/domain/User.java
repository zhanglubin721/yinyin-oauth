package com.cloudplus.oauth.yinyinoauth.project.user.domain;

/**
 * @author zhanglubin
 * @date 2021/2/4
 */
public class User {

    private Long userId;
    private String loginName;
    private String password;
    private String salt;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User(Long userId, String loginName, String password, String salt) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.salt = salt;
    }

    public User() {
    }
}
