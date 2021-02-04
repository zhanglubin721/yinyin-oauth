package com.cloudplus.oauth.yinyinoauth.project.user.mapper;

import com.cloudplus.oauth.yinyinoauth.project.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/4
 */
@Mapper
public interface UserMapper {

    List<User> selectUser(User user);
}
