package com.alphabet.dal;

import com.alphabet.entity.UserDOModel.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 新增
     * @param userDO
     * @return
     */
    int insert(UserDO userDO);

    /**
     * 删除用户
     * @param userDO
     * @return
     */
    int del(UserDO userDO);

    /**
     * 更新用户
     * @return
     */
    int updateUser(UserDO userDO);

    /**
     * 获取多个用户
     * @return
     */
    List<UserDO> queryUsers(UserDO userDO);

    /**
     * 获取用户
     * @param userDO
     * @return
     */
    UserDO querySingleUser(UserDO userDO);
}
