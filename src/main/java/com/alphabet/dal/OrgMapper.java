package com.alphabet.dal;

import com.alphabet.entity.OrgDOModel.OrgDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * sql映射类
 */
@Repository
public interface OrgMapper {

    /**
     * 新增
     * @param orgDO
     * @return
     */
    int insert(OrgDO orgDO);

    /**
     * 删除部门
     * @param orgDO
     * @return
     */
    int del(OrgDO orgDO);

    /**
     * 修改部门
     * @param orgDO
     * @return
     */
    int update(OrgDO orgDO);

    /**
     * 获取多个部门
     * @param orgDO
     * @return
     */
    List<OrgDO> queryOrgs(OrgDO orgDO);

    /**
     * 获取单个部门
     * @param orgDO
     * @return
     */
    OrgDO queryOrg(OrgDO orgDO);
}
