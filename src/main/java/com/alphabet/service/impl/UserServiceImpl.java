package com.alphabet.service.impl;

import com.alphabet.dao.UserDao;
import com.alphabet.entity.UserEntity;
import com.alphabet.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:41
 **/
@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    /**
     * 获取所有在职用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:16
     * @return
     **/
    @Override
    public List<UserEntity> queryAllUser() {
        return userDao.queryAllUser();
    }

    /**
     * 根据id获取用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:16
     * @param id
     * @return com.alphabet.entity.UserEntity
     **/
    @Override
    public UserEntity getUserById(String id) {
        return userDao.getUserById(id);
    }

    /**
     * 根据userId获取用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:17
     * @param userId
     * @return com.alphabet.entity.UserEntity
     **/
    @Override
    public UserEntity getUserByUserId(String userId) {
        return userDao.getUserByUserId(userId);
    }

    /**
     * 根据用户名和密码获取用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:18
     * @param userName
     * @param password
     * @return com.alphabet.entity.UserEntity
     **/
    @Override
    public UserEntity getUserByInfo(String userName, String password) {
        return userDao.getUserByInfo(userName,password);
    }

    /**
     * 根据组织id获取在职用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:19
     * @param orgId
     * @return java.util.List<com.alphabet.entity.UserEntity>
     **/
    @Override
    public List<UserEntity> getUserByOrgId(String orgId) {
        return userDao.getUserByOrgId(orgId);
    }

    /**
     * 获取所有离职用户
     * @Author yang.lvsen
     * @Date 2018/6/11 17:19
     * @param
     * @return java.util.List<com.alphabet.entity.UserEntity>
     **/
    @Override
    public List<UserEntity> getQuitUser() {
        return userDao.getQuitUser();
    }
}
