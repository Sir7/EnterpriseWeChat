package com.alphabet.service;

import com.alphabet.entity.UserEntity;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:40
 **/
public interface UserService {

    //获取所有在职用户
    public List<UserEntity> queryAllUser();

    //根据id获取用户
    public UserEntity getUserById(String id);

    //根据userId获取用户
    public UserEntity getUserByUserId(String userId);

    //根据用户名和密码获取用户
    public UserEntity getUserByInfo(String userName,String password);

    //根据组织id获取在职用户
    public List<UserEntity> getUserByOrgId(String orgId);

    //获取所有离职用户
    public List<UserEntity> getQuitUser();
}
