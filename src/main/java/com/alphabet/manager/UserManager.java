package com.alphabet.manager;

import com.alphabet.dal.UserMapper;
import com.alphabet.entity.UserDOModel.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yanglvsen
 * @version V1.0
 * @Title TODO
 * @Description TODO
 * @Package com.alphabet.manager
 * @date 2019/9/25 20:12
 */
@Component
public class UserManager {

    public UserManager(){}

    @Autowired
    UserMapper userMapper;

    /**
     * 新增用户
     * @param userDO
     * @return
     */
    public Boolean addUser(UserDO userDO){
        return userMapper.insert(userDO) > 0;
    }

    /**
     * 删除用户
     * @param userDO
     * @return
     */
    public Boolean removeUser(UserDO userDO){
        return userMapper.del(userDO) > 0;
    }

    /**
     * 修改用户
     * @param userDO
     * @return
     */
    public Boolean updateUser(UserDO userDO){
        return userMapper.updateUser(userDO) > 0;
    }

    /**
     * 获取用户
     * @param userDO
     * @return
     */
    public UserDO querySingleUser(UserDO userDO){
        return userMapper.queryUser(userDO);
    }

    /**
     * 更新用户信息
     * @param userDO
     * @return
     */
    public Boolean modifyUser(UserDO userDO){
        return userMapper.updateUser(userDO) > 0;
    }

    /**
     * 获取多个用户
     * @param userDO
     * @return
     */
    public List<UserDO> queryUsers(UserDO userDO){
        return userMapper.queryUsers(userDO);
    }

}
