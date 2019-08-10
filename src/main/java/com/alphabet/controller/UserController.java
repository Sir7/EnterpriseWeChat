package com.alphabet.controller;

import com.alphabet.entity.UserDOModel.UserDO;
import com.alphabet.model.requestModel.UserReqDTO.AddUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.DelUserReqDTO;
import com.alphabet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param addUserReqDTO
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String AddUser(AddUserReqDTO addUserReqDTO){
        try{
            LOGGER.info("新增用户请求参数{}", addUserReqDTO);
            Boolean aBoolean = userService.addUser(addUserReqDTO);
            LOGGER.info("新增用户请求参数，返回结果：{}",aBoolean);
        }catch (Exception e){
            LOGGER.error("新增用户请求参数失败，异常信息：{}",e);
        }
        return null;
    }

    /**
     * 删除用户
     * @param delUserReqDTO
     * @return
     */
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public String AddUser(DelUserReqDTO delUserReqDTO){
        try{
            LOGGER.info("删除用户请求参数{}", delUserReqDTO);
            Boolean aBoolean = userService.delUser(delUserReqDTO);
            LOGGER.info("删除用户请求参数，返回结果：{}",aBoolean);
        }catch (Exception e){
            LOGGER.error("删除用户请求参数失败，异常信息：{}",e);
        }
        return null;
    }

    /**
     * 获取所有用户
     *
     * @param
     * @return java.lang.String
     * @Author yang.lvsen
     * @Date 2018/6/11 17:22
     **/
    @RequestMapping(value = "/queryAllUser", method = RequestMethod.POST)
    public ModelAndView queryAllUser() {
        List<UserDO> userList = userService.queryAllUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject(userList);
        mv.setViewName("user/queryAllUser");
        return mv;
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang.lvsen
     * @Date 2018/6/11 17:29
     **/
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public ModelAndView getUserById(@RequestParam String id) {
        UserDO user = userService.getUserById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setViewName("user/getUserById");
        return mv;
    }

    /**
     * 根据userId获取用户
     *
     * @param userId
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang.lvsen
     * @Date 2018/6/11 17:30
     **/
    @RequestMapping(value = "/getUserByUserId", method = RequestMethod.POST)
    public ModelAndView getUserByUserId(@RequestParam String userId) {
        UserDO user = userService.getUserByUserId(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setViewName("user/getUserByUserId");
        return mv;
    }

    /**
     * 根据用户名和密码获取用户
     *
     * @param userName
     * @param password
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang.lvsen
     * @Date 2018/6/11 17:40
     **/
    @RequestMapping(value = "/getUserByInfo", method = RequestMethod.POST)
    public ModelAndView getUserByInfo(@RequestParam String userName, @RequestParam String password) {
        UserDO user = userService.getUserByInfo(userName, password);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setViewName("user/getUserByInfo");
        return mv;
    }

    /**
     * @param orgId
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang.lvsen
     * @Date 2018/6/11 17:42
     **/
    @RequestMapping(value = "/getUserByOrgId", method = RequestMethod.POST)
    public ModelAndView getUserByOrgId(@RequestParam String orgId) {
        List<UserDO> userList = userService.getUserByOrgId(orgId);
        ModelAndView mv = new ModelAndView();
        mv.addObject(userList);
        mv.setViewName("user/getUserByOrgId");
        return mv;
    }

    /**
     * 获取所有离职用户
     *
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang.lvsen
     * @Date 2018/6/11 17:44
     **/
    @RequestMapping(value = "/getQuitUser", method = RequestMethod.POST)
    public ModelAndView getQuitUser() {
        List<UserDO> userList = userService.getQuitUser();
        ModelAndView mv = new ModelAndView();
        mv.addObject(userList);
        mv.setViewName("user/getQuitUser");
        return mv;
    }

}
