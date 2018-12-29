package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Role;
import com.itheima.domain.UsersInfo;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersInfo usersInfo =  userMapper.findUserByName(username);
        User user = new User(usersInfo.getUsername(),usersInfo.getPassword(),
                usersInfo.getStatus()==1?true:false,true,true,
                true,getRole(usersInfo));
        return user;
    }

    private List<SimpleGrantedAuthority> getRole(UsersInfo usersInfo) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        List<Role> roleList = usersInfo.getRoleList();
        for (Role role : roleList) {
            SimpleGrantedAuthority sga= new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            list.add(sga);
        }
        return list;
    }

    @Override
    public List<UsersInfo> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.findAll();
    }

    @Override
    public void save(UsersInfo usersInfo) throws Exception {
        userMapper.save(usersInfo);
    }

    @Override
    public UsersInfo findUserAndRoleById(String id) throws Exception {
        return userMapper.findUserAndRoleById(id);
    }
}
