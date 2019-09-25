package com.alphabet.service;

import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.model.requestModel.OrgReqDTO.*;

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
     *
     * @param delOrgReqDTO
     * @return
     */
    Boolean delOrg(DelOrgReqDTO delOrgReqDTO);

    /**
     * 修改部门
     *
     * @param updateOrgReqDTO
     * @return
     */
    Boolean updateOrg(UpdateOrgReqDTO updateOrgReqDTO);

    /**
     * 获取多个部门
     *
     * @return
     */
    List<OrgDO> queryOrgs(QueryOrgsReqDTO queryOrgsReqDTO);

    /**
     * 查询单个部门
     *
     * @param queryOrgReqDTO
     * @return
     */
    OrgDO querySingleOrg(QueryOrgReqDTO queryOrgReqDTO);

}
