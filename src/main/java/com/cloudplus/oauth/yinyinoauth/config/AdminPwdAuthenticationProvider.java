package com.cloudplus.oauth.yinyinoauth.config;

import com.cloudplus.oauth.yinyinoauth.project.user.domain.User;
import com.cloudplus.oauth.yinyinoauth.project.user.service.UserService;
import freemarker.template.SimpleHash;
import lombok.SneakyThrows;
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

import java.security.MessageDigest;
import java.util.List;

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

    @Autowired
    private UserService userService;

    //自定义认证方法
    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken adminLoginToken = (UsernamePasswordAuthenticationToken) authentication;
        //通过用户输入的用户名查询出security框架中现有的匹配到的用户
        UserDetails userDetails = adminUserDetailsService.loadUserByUsername(adminLoginToken.getName());
        User user = new User();
        user.setLoginName(userDetails.getUsername());
        List<User> userData = userService.getUser(user);
        //进行密码校验（前面为明文，后面为框架中存储的加密后密文）
        String encryptionPassword = "";
        if (userData.size() == 1) {
            //加密得到加密密码
            String passwordStr = userDetails.getUsername() + authentication.getCredentials().toString() + userData.get(0).getSalt();
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(passwordStr.getBytes("UTF8"));
            byte s[] = m.digest();
            for (int i = 0; i < s.length; i++) {
                encryptionPassword += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
        } else {
            throw new BadCredentialsException("查询出多个相同登录名的用户");
        }
        if (passwordEncoder.matches(encryptionPassword,userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        }
        throw new BadCredentialsException("用户名密码不正确");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
