package com.cloudplus.oauth.yinyinoauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author zhanglubin
 * @date 2021/1/29
 */
@Component
public class AdminPwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService adminUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //自定义认证方法
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken adminLoginToken = (UsernamePasswordAuthenticationToken) authentication;
        //通过用户输入的用户名查询出security框架中现有的匹配到的用户
        UserDetails userDetails = adminUserDetailsService.loadUserByUsername(adminLoginToken.getName());
        //进行密码校验（前面为明文，后面为框架中存储的加密后密文）
        if (passwordEncoder.matches(authentication.getCredentials().toString(),userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        }
        throw new BadCredentialsException("用户名密码不正确");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
