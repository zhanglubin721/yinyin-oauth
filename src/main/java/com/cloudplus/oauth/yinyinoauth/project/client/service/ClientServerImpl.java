package com.cloudplus.oauth.yinyinoauth.project.client.service;

import com.cloudplus.oauth.yinyinoauth.project.client.domain.Client;
import com.cloudplus.oauth.yinyinoauth.project.client.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/3
 */
@Service
public class ClientServerImpl implements ClientServer{

    @Autowired
    private ClientMapper clientMapper;

    /**
     * 制作动态初始化登录所需客户端信息配置的假数据，正常情况下需要查询数据库
     * @return
     */
    @Override
    public List<Client> getClientData(Client client) {
        List<Client> clients = clientMapper.selectClient(client);
        return clients;
    }
}
