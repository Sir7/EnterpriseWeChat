package com.alphabet.dao;

import com.alphabet.entity.OrgEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgDao {

    //获取所有部门
    public List<OrgEntity> queryAllOrg();

    //根据部门id获取部门
    public OrgEntity getOrgByOrgId(String orgId);

    //根据主键id获取部门
    public OrgEntity getOrgById(String id);

    //根据部门名称获取部门
    public OrgEntity getOrgByName(String orgName);
}
