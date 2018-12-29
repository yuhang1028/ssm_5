package com.itheima.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class UsersInfo implements Serializable {
    private String id;
    @Email(message = "格式有误")
    private String email;
    @Size(min = 1,max=8,message = "用户名长度不在1-8之间")
    private String username;
    @Size(min = 1,max = 10,message = "密码在1-10位之间")
    private String password;
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$",message = "手机号码格式错误")
    private String phoneNum;
    private Integer status;
    private String statusStr;
    //用户跟角色关系:一对多
    private List<Role> roleList;

    public String getStatusStr() {
        if (status != null){
            if (status==0){
                statusStr ="未开启";
            }else {
                statusStr="开启";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
