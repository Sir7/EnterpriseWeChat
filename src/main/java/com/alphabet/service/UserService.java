package com.alphabet.service;

import com.alphabet.entity.UserDOModel.UserDO;
import com.alphabet.requestModel.UserModel.AddUserReqDTO;
import com.alphabet.requestModel.UserModel.DelUserReqDTO;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:40
 **/
public interface UserService {

    /**
     * 新增用户
     * @param addUserReqDTO
     * @return
     */
    Boolean addUser(AddUserReqDTO addUserReqDTO);

    /**
     * 删除用户
     * @param delUserReqDTO
     * @return
     */
    Boolean delUser(DelUserReqDTO delUserReqDTO);

    /**
     * 获取所有在职用户
     * @return
     */
    List<UserDO> queryAllUser();

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    UserDO getUserById(String id);

    /**
     * 根据userId获取用户
     * @param userId
     * @return
     */
    UserDO getUserByUserId(String userId);

    /**
     * 根据用户名和密码获取用户
     * @param userName
     * @param password
     * @return
     */
    UserDO getUserByInfo(String userName, String password);

    /**
     * 根据组织id获取在职用户
     * @param orgId
     * @return
     */
    List<UserDO> getUserByOrgId(String orgId);

    /**
     * 获取所有离职用户
     * @return
     */
    List<UserDO> getQuitUser();
}
