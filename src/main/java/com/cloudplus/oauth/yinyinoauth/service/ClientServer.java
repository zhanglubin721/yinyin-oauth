package com.cloudplus.oauth.yinyinoauth.service;

import com.cloudplus.oauth.yinyinoauth.domain.Client;

import java.util.ArrayList;

/**
 * @author zhanglubin
 * @date 2021/2/3
 */
public interface ClientServer {
    ArrayList<Client> getClientData();
}
