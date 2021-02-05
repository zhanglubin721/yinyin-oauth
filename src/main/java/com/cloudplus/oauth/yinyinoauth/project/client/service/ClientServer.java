package com.cloudplus.oauth.yinyinoauth.project.client.service;

import com.cloudplus.oauth.yinyinoauth.project.client.domain.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/3
 */
public interface ClientServer {
    List<Client> getClientData(Client client);
}
