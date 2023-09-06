package com.zlennon.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zlennon.mybatisplus.entity.User;
import com.zlennon.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.Doc;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.query;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlennon
 * @since 2023-08-17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("getAllUsers")
    @ResponseBody
    public Object  getAllUsers(){
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("json->'$.extensions.endpoints.Default.introspect'", 0);
       // queryWrapper.eq("name", "dsfdsf");
        return userService.list(queryWrapper);
        //return userService.
    }

}
