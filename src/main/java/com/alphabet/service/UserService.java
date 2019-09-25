package com.alphabet.service;

import com.alphabet.entity.UserDOModel.UserDO;
import com.alphabet.model.requestModel.UserReqDTO.AddUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.DelUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.QueryUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.UpdateUserReqDTO;

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
     * 修改用户
     * @param updateUserReqDTO
     * @return
     */
    Boolean updateUser(UpdateUserReqDTO updateUserReqDTO);

    /**
     * 获取多个用户
     * @param queryUserReqDTO
     * @return
     */
    List<UserDO> queryUsers(QueryUserReqDTO queryUserReqDTO);

    /**
     * 根据id获取用户
     * @param queryUserReqDTO
     * @return
     */
    UserDO querySingleUser(QueryUserReqDTO queryUserReqDTO);

}
