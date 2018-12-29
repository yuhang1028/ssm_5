package com.itheima.mapper;

import com.itheima.domain.UsersInfo;

import java.util.List;

public interface UserMapper {

    UsersInfo findUserByName(String username);

    List<UsersInfo> findAll() throws Exception;

    void save(UsersInfo usersInfo)throws  Exception;

    UsersInfo findUserAndRoleById(String id) throws Exception;
}
