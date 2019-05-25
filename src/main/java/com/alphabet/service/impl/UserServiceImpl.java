package com.alphabet.service.impl;

import com.alphabet.conver.UserConver;
import com.alphabet.entity.UserBOModel.UserBO;
import com.alphabet.entity.UserDOModel.UserDO;
import com.alphabet.manager.UserMapper;
import com.alphabet.requestModel.UserModel.AddUserReqDTO;
import com.alphabet.requestModel.UserModel.DelUserReqDTO;
import com.alphabet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:41
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userManager;
    @Autowired
    private UserConver userConver;

    /**
     * 新增用户
     * @param addUserReqDTO
     * @return
     */
    @Override
    public Boolean addUser(AddUserReqDTO addUserReqDTO) {
        UserBO userBO = userConver.addUserReqDtoToBO(addUserReqDTO);
        UserDO userDO = userConver.userBOToDO(userBO);
        Boolean aBoolean = userManager.insert(userDO);
        return aBoolean;
    }

    @Override
    public Boolean delUser(DelUserReqDTO delUserReqDTO) {
        UserBO userBO = userConver.delUserReqDtoToBO(delUserReqDTO);
        UserDO userDO = userConver.userBOToDO(userBO);
        Boolean aBoolean = userManager.del(userDO);
        return aBoolean;
    }

    /**
     * 获取所有在职用户
     *
     * @return
     * @Author yang.lvsen
     * @Date 2018/6/11 17:16
     **/
    @Override
    public List<UserDO> queryAllUser() {
        return userManager.queryAllUser();
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return com.alphabet.entity.UserDOModel.UserDOModel
     * @Author yang.lvsen
     * @Date 2018/6/11 17:16
     **/
    @Override
    public UserDO getUserById(String id) {
        return userManager.getUserById(id);
    }

    /**
     * 根据userId获取用户
     *
     * @param userId
     * @return com.alphabet.entity.UserDOModel.UserDOModel
     * @Author yang.lvsen
     * @Date 2018/6/11 17:17
     **/
    @Override
    public UserDO getUserByUserId(String userId) {
        return userManager.getUserByUserId(userId);
    }

    /**
     * 根据用户名和密码获取用户
     *
     * @param userName
     * @param password
     * @return com.alphabet.entity.UserDOModel.UserDOModel
     * @Author yang.lvsen
     * @Date 2018/6/11 17:18
     **/
    @Override
    public UserDO getUserByInfo(String userName, String password) {
        return userManager.getUserByInfo(userName, password);
    }

    /**
     * 根据组织id获取在职用户
     *
     * @param orgId
     * @return java.util.List<com.alphabet.entity.UserDOModel.UserDOModel>
     * @Author yang.lvsen
     * @Date 2018/6/11 17:19
     **/
    @Override
    public List<UserDO> getUserByOrgId(String orgId) {
        return userManager.getUserByOrgId(orgId);
    }

    /**
     * 获取所有离职用户
     *
     * @param
     * @return java.util.List<com.alphabet.entity.UserDOModel.UserDOModel>
     * @Author yang.lvsen
     * @Date 2018/6/11 17:19
     **/
    @Override
    public List<UserDO> getQuitUser() {
        return userManager.getQuitUser();
    }
}
