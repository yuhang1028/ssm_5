package com.itheima.service;

import com.itheima.domain.UsersInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UsersInfo> findAll(Integer pageNum, Integer pageSize) throws Exception;

    void save(UsersInfo usersInfo)throws Exception;

    UsersInfo findUserAndRoleById(String id) throws Exception;
}
