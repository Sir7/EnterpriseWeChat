package com.alphabet.controller;

import com.alphabet.entity.UserEntity;
import com.alphabet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 用户
 * @Author yang.lvsen
 * @Date 2018/6/6 21:37
 **/

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    //注入
    @Resource
    private UserService userService;


    /**
     * 获取所有用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:22
     * @param
     * @return java.lang.String
     **/
    @RequestMapping("/queryAllUser")
    public ModelAndView queryAllUser(){
        List<UserEntity> userList = userService.queryAllUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject(userList);
        mv.setViewName("user/queryAllUser");
        return mv;
    }

    /**
     * 根据id获取用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:29
     * @param id
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/getUserById")
    public ModelAndView getUserById(@RequestParam String id){
        UserEntity user = userService.getUserById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setViewName("user/getUserById");
        return mv;
    }

    /**
     * 根据userId获取用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:30
     * @param userId
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/getUserByUserId")
    public ModelAndView getUserByUserId(@RequestParam String userId){
        UserEntity user = userService.getUserByUserId(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setViewName("user/getUserByUserId");
        return mv;
    }

    /**
     * 根据用户名和密码获取用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:40
     * @param userName
     * @param password
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("getUserByInfo")
    public ModelAndView getUserByInfo(@RequestParam String userName,@RequestParam String password){
        UserEntity user = userService.getUserByInfo(userName,password);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setViewName("user/getUserByInfo");
        return mv;
    }

    /**
     *
     * @Author yang.lvsen
     * @Date 2018/6/11 17:42
     * @param orgId
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("getUserByOrgId")
    public ModelAndView getUserByOrgId(@RequestParam String orgId){
        List<UserEntity> userList = userService.getUserByOrgId(orgId);
        ModelAndView mv = new ModelAndView();
        mv.addObject(userList);
        mv.setViewName("user/getUserByOrgId");
        return mv;
    }

    /**
     * 获取所有离职用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:44
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("getQuitUser")
    public ModelAndView getQuitUser(){
        List<UserEntity> userList = userService.getQuitUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject(userList);
        mv.setViewName("user/getQuitUser");
        return mv;
    }

}
