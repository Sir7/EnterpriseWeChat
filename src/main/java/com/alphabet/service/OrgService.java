package com.alphabet.service;

import com.alphabet.entity.OrgEntity;

import java.util.List;

/**
 * @ClassName OrgService
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:40
 **/

public interface OrgService {

    //获取所有部门
    public List<OrgEntity> queryAllOrg();

    //根据部门id获取部门
    public OrgEntity getOrgByOrgId(String orgId);

    //根据主键id获取部门
    public OrgEntity getOrgById(String id);

    //根据部门名称获取部门
    public OrgEntity getOrgByName(String orgName);
}
