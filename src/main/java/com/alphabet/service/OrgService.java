package com.alphabet.service;

import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.requestModel.OrgModel.AddOrgReqDTO;
import com.alphabet.requestModel.OrgModel.DelOrgReqDTO;

import java.util.List;

/**
 * @ClassName OrgService
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:40
 **/
public interface OrgService {

    /**
     * 新增部门
     *
     * @param addOrgReqDTO
     * @return
     */
    Boolean addOrg(AddOrgReqDTO addOrgReqDTO);

    /**
     * 删除部门
     * @param delOrgReqDTO
     * @return
     */
    Boolean delOrg(DelOrgReqDTO delOrgReqDTO);

    /**
     * 获取所有部门
     *
     * @return
     */
    List<OrgDO> queryAllOrg();

    /**
     * 根据部门id获取部门
     *
     * @param orgId
     * @return
     */
    OrgDO getOrgByOrgId(String orgId);

    /**
     * 根据主键id获取部门
     *
     * @param id
     * @return
     */
    OrgDO getOrgById(String id);

    /**
     * 根据部门名称获取部门
     *
     * @param orgName
     * @return
     */
    OrgDO getOrgByName(String orgName);

}
