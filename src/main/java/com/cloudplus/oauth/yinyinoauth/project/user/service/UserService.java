package com.cloudplus.oauth.yinyinoauth.project.user.service;

import com.cloudplus.oauth.yinyinoauth.project.user.domain.User;

import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/4
 */
public interface UserService {

    List<User> getUser(User user);
}
