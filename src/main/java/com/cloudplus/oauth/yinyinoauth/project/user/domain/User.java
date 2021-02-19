package com.cloudplus.oauth.yinyinoauth.project.user.domain;

import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/4
 */
public class User {

    private Long userId;
    private String loginName;
    private String password;
    private String salt;
    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(Long userId, String loginName, String password, String salt, List<Role> roles) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.salt = salt;
        this.roles = roles;
    }

    public User() {
    }
}
