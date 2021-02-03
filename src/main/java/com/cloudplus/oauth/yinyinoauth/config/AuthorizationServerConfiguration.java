package com.cloudplus.oauth.yinyinoauth.config;

import com.cloudplus.oauth.yinyinoauth.domain.AuthorizedGrantType;
import com.cloudplus.oauth.yinyinoauth.domain.Client;
import com.cloudplus.oauth.yinyinoauth.domain.RedirectUri;
import com.cloudplus.oauth.yinyinoauth.service.ClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/1/29
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    //accessToken 过期
    private int accessTokenValiditySecond = 60 * 60 * 2; //2小时
    private int refreshTokenValiditySecond = 60 * 60 * 24 * 7; // 7 天

    @Autowired
    private ClientServer clientServer;

    //添加商户信息
    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        //访问服务，获取客户端配置信息
        //withClient Appid
        InMemoryClientDetailsServiceBuilder inMemoryClientDetailsServiceBuilder = configurer.inMemory();
        ArrayList<Client> clients = clientServer.getClientData();
        for (Client client : clients) {
            ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder>.ClientBuilder secret = inMemoryClientDetailsServiceBuilder.withClient(client.getClientId()).secret(passwordEncoder().encode(client.getClientSecret()));
            List<AuthorizedGrantType> authorizedGrantTypes = client.getAuthorizedGrantTypes();
            List<RedirectUri> redirectUris = client.getRedirectUris();
            if (authorizedGrantTypes != null && authorizedGrantTypes.size() > 0) {
                //设置授权码模式
                for (AuthorizedGrantType authorizedGrantType : authorizedGrantTypes) {
                    secret.authorizedGrantTypes(authorizedGrantType.getAuthorizedGrantType());
                }
            }
            if (redirectUris != null && redirectUris.size() > 0) {
                //设置授权码模式
                for (RedirectUri redirectUri : redirectUris) {
                    secret.redirectUris(redirectUri.getUri());
                }
            }
            //false跳转到授权页面
            secret.autoApprove(false)
                    .accessTokenValiditySeconds(accessTokenValiditySecond)
                    .refreshTokenValiditySeconds(refreshTokenValiditySecond);
        }
//        inMemoryClientDetailsServiceBuilder.withClient("yinyinShop").secret(passwordEncoder().encode("123456"))
//                //设置授权码模式
//                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
//                .redirectUris("http://www.baidu.com")
//                .autoApprove(false)//false跳转到授权页面
//
//                .accessTokenValiditySeconds(accessTokenValiditySecond)
//                .refreshTokenValiditySeconds(refreshTokenValiditySecond);
    }

    //定义授权和令牌端点和令牌服务
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer){
        //刷新令牌时需要的认证管理和用户信息来源
        endpointsConfigurer.authenticationManager(authenticationManager()).allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
        endpointsConfigurer.authenticationManager(authenticationManager());
        endpointsConfigurer.userDetailsService(userDetailsService());
        endpointsConfigurer.pathMapping("/oauth/confirm_access","/custom/confirm_access");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients();
        //允许 check_token 访问
        oauthServer.checkTokenAccess("permitAll()");
    }

    @Bean
    AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return daoAuhthenticationProvider().authenticate(authentication);
            }
        };
        return authenticationManager;
    }

    @Bean
    public AuthenticationProvider daoAuhthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    // 设置添加用户信息,正常应该从数据库中读取
    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(User.withUsername("user").password(passwordEncoder().encode("123456"))
                .authorities("ROLE_USER").build());
        return userDetailsService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // 加密方式
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

}