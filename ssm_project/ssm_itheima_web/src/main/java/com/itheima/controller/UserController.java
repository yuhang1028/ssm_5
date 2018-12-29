package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.UsersInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  UserService userService ;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 查询所有
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(required = false,defaultValue = "1")Integer pageNum,
                          @RequestParam(required = false,defaultValue = "4") Integer pageSize) throws Exception {
        List<UsersInfo> users = userService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(users);
        model.addAttribute("userList",pageInfo);
        System.out.println(pageInfo.getPageSize()+"---------------------------");
        return "user-list";
    }

    /**
     * 添加用户
     * @param usersInfo
     * @return
     */
    @RequestMapping("/save")
    public String save(@Validated UsersInfo usersInfo, BindingResult result,ModelMap model) throws Exception {
        if (result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "user-add";
        }
        System.out.println("-----------------------------------------");
        userService.save(usersInfo);
        return "redirect:/user/findAll";
    }
    @RequestMapping("/findById")
    public String findUserAndRoleById(String id,Model model) throws Exception {
     UsersInfo usersInfo =  userService.findUserAndRoleById(id);
     model.addAttribute("user",usersInfo);
     return "user-show";
    }
}
