package com.alphabet.controller;

import com.alphabet.entity.UserDOModel.UserDO;
import com.alphabet.model.requestModel.UserReqDTO.AddUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.DelUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.QueryUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.UpdateUserReqDTO;
import com.alphabet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description 用户
 * @Author yang.lvsen
 * @Date 2018/6/6 21:37
 **/
@Slf4j
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param addUserReqDTO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String AddUser(AddUserReqDTO addUserReqDTO){
        try{
            log.info("新增用户请求参数{}", addUserReqDTO);
            Boolean aBoolean = userService.addUser(addUserReqDTO);
            log.info("新增用户请求参数，返回结果：{}",aBoolean);
        }catch (Exception e){
            log.error("新增用户请求参数失败，异常信息：{}",e);
        }
        return null;
    }

    /**
     * 删除用户
     * @param delUserReqDTO
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String DelUser(DelUserReqDTO delUserReqDTO){
        try{
            log.info("删除用户请求参数{}", delUserReqDTO);
            Boolean aBoolean = userService.delUser(delUserReqDTO);
            log.info("删除用户请求参数，返回结果：{}",aBoolean);
        }catch (Exception e){
            log.error("删除用户请求参数失败，异常信息：{}",e);
        }
        return null;
    }

    /**
     * 修改用户
     * @param updateUserReqDTO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String UpdateUser(UpdateUserReqDTO updateUserReqDTO){
        try{
            log.info("修改用户请求参数{}", updateUserReqDTO);
            Boolean aBoolean = userService.updateUser(updateUserReqDTO);
            log.info("修改用户请求参数，返回结果：{}",aBoolean);
        }catch (Exception e){
            log.error("修改用户请求参数失败，异常信息：{}",e);
        }
        return null;
    }

    /**
     * 获取多个用户
     *
     * @param
     * @return java.lang.String
     * @Author yang.lvsen
     * @Date 2018/6/11 17:22
     **/
    @RequestMapping(value = "/queryUsers", method = RequestMethod.POST)
    public ModelAndView queryUsers(QueryUserReqDTO queryUserReqDTO) {
        List<UserDO> userList = userService.queryUsers(queryUserReqDTO);
        ModelAndView mv = new ModelAndView();
        mv.addObject(userList);
        mv.setViewName("user/queryAllUser");
        return mv;
    }

    /**
     * 根据id获取用户
     *
     * @param queryUserReqDTO
     * @return org.springframework.web.servlet.ModelAndView
     * @Author yang.lvsen
     * @Date 2018/6/11 17:29
     **/
    @RequestMapping(value = "/querySingleUser", method = RequestMethod.POST)
    public ModelAndView querySingleUser(QueryUserReqDTO queryUserReqDTO) {
        UserDO user = userService.querySingleUser(queryUserReqDTO);
        ModelAndView mv = new ModelAndView();
        mv.addObject(user);
        mv.setViewName("user/getUserById");
        return mv;
    }

}
