package com.alphabet.service.impl;

import com.alphabet.converter.UserConverter;
import com.alphabet.entity.UserBOModel.UserBO;
import com.alphabet.entity.UserDOModel.UserDO;
import com.alphabet.manager.UserManager;
import com.alphabet.model.requestModel.UserReqDTO.AddUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.DelUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.QueryUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.UpdateUserReqDTO;
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
    private UserManager userManager;
    @Autowired
    private UserConverter userConverter;

    /**
     * 新增用户
     *
     * @param addUserReqDTO
     * @return
     */
    @Override
    public Boolean addUser(AddUserReqDTO addUserReqDTO) {
        Boolean aBoolean = false;
        UserBO userBO = userConverter.addUserReqDtoToBO(addUserReqDTO);
        if(userBO == null){
            return aBoolean;
        }
        UserDO userDO = userConverter.userBOToDO(userBO);
        aBoolean = userManager.addUser(userDO);
        return aBoolean;
    }

    @Override
    public Boolean delUser(DelUserReqDTO delUserReqDTO) {
        Boolean aBoolean = false;
        UserBO userBO = userConverter.delUserReqDtoToBO(delUserReqDTO);
        if(userBO == null){
            return aBoolean;
        }
        UserDO userDO = userConverter.userBOToDO(userBO);
        aBoolean = userManager.removeUser(userDO);
        return aBoolean;
    }

    @Override
    public Boolean updateUser(UpdateUserReqDTO updateUserReqDTO) {
        Boolean aBoolean = false;
        UserBO userBO = userConverter.updateUserReqDtoToBO(updateUserReqDTO);
        if(userBO == null){
            return aBoolean;
        }
        UserDO userDO = userConverter.userBOToDO(userBO);
        return userManager.updateUser(userDO);
    }

    /**
     * 获取多个用户
     * @param queryUserReqDTO
     * @return
     */
    @Override
    public List<UserDO> queryUsers(QueryUserReqDTO queryUserReqDTO) {
        UserDO userDO = userConverter.userBOToDO(userConverter.queryUserReqDtoToBO(queryUserReqDTO));
        return userManager.queryUsers(userDO);
    }

    /**
     * 根据id获取用户
     * @param queryUserReqDTO
     * @return
     */
    @Override
    public UserDO querySingleUser(QueryUserReqDTO queryUserReqDTO) {
        UserDO userDO = userConverter.userBOToDO(userConverter.queryUserReqDtoToBO(queryUserReqDTO));
        return userManager.querySingleUser(userDO);
    }

}
