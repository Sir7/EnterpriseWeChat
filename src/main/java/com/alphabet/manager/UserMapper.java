package com.alphabet.manager;

import com.alphabet.entity.UserDOModel.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 获取所有在职用户
     *
     * @return
     */
    List<UserDO> queryAllUser();

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    UserDO getUserById(String id);

    /**
     * 根据userId获取用户
     *
     * @param userId
     * @return
     */
    UserDO getUserByUserId(String userId);

    /**
     * 根据用户名和密码获取用户
     *
     * @param userName
     * @param password
     * @return
     */
    UserDO getUserByInfo(String userName, String password);

    /**
     * 根据组织id获取在职用户
     *
     * @param orgId
     * @return
     */
    List<UserDO> getUserByOrgId(String orgId);

    /**
     * 获取所有离职用户
     *
     * @return
     */
    List<UserDO> getQuitUser();

    /**
     * 新增
     *
     * @param userDO
     * @return
     */
    Boolean insert(UserDO userDO);

    /**
     * 删除用户
     * @param userDO
     * @return
     */
    Boolean del(UserDO userDO);
}
