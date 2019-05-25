package com.alphabet.manager;

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

    //获取所有部门
    List<OrgDO> queryAllOrg();

    //根据部门id获取部门
    OrgDO getOrgByOrgId(String orgId);

    //根据主键id获取部门
    OrgDO getOrgById(String id);

    //根据部门名称获取部门
    OrgDO getOrgByName(String orgName);

}
