package com.cloudplus.oauth.yinyinoauth.project.client.mapper;

import com.cloudplus.oauth.yinyinoauth.project.client.domain.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhanglubin
 * @date 2021/2/4
 */
@Mapper
public interface ClientMapper {

    List<Client> selectClient(Client client);
}
