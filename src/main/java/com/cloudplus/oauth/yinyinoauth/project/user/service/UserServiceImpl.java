package com.cloudplus.oauth.yinyinoauth.project.user.service;

import com.cloudplus.oauth.yinyinoauth.project.user.domain.User;
import com.cloudplus.oauth.yinyinoauth.project.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/4
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser(User user) {
        List<User> users = userMapper.selectUser(user);
        return users;
    }
}
