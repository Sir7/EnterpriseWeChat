package com.alphabet.service.impl;

import com.alphabet.converter.OrgConverter;
import com.alphabet.entity.OrgBOModel.OrgBO;
import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.manager.OrgManager;
import com.alphabet.model.requestModel.OrgReqDTO.*;
import com.alphabet.service.OrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:47
 **/
@Slf4j
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgManager orgManager;
    @Autowired
    private OrgConverter orgConverter;

    /**
     * 新增部门
     *
     * @param addOrgReqDTO
     * @return
     */
    @Override
    public Boolean addOrg(AddOrgReqDTO addOrgReqDTO) {
        Boolean aBoolean = false;
        OrgBO orgBO = orgConverter.orgReqDtoToBO(addOrgReqDTO);
        if(orgBO == null){
            return aBoolean;
        }
        OrgDO orgDO = orgConverter.orgBOToDO(orgBO);
        return orgManager.delOrg(orgDO);
    }

    /**
     * 删除部门
     *
     * @param delOrgReqDTO
     * @return
     */
    @Override
    public Boolean delOrg(DelOrgReqDTO delOrgReqDTO) {
        Boolean aBoolean = false;
        OrgBO orgBO = orgConverter.delOrgDtoToBO(delOrgReqDTO);
        if(orgBO == null){
            return aBoolean;
        }
        OrgDO orgDO = orgConverter.orgBOToDO(orgBO);
        return orgManager.addOrg(orgDO);
    }

    /**
     * 修改部门
     *
     * @param updateOrgReqDTO
     * @return
     */
    @Override
    public Boolean updateOrg(UpdateOrgReqDTO updateOrgReqDTO) {
        Boolean aBoolean = false;
        OrgBO orgBO = orgConverter.updateOrgDtoToBO(updateOrgReqDTO);
        if(orgBO == null){
            return aBoolean;
        }
        OrgDO orgDO = orgConverter.orgBOToDO(orgBO);
        return orgManager.modifyOrg(orgDO);
    }

    @Override
    public List<OrgDO> queryOrgs(QueryOrgsReqDTO queryOrgsReqDTO) {
        OrgBO orgBO = orgConverter.queryOrgsDtoToBO(queryOrgsReqDTO);
        return orgManager.queryOrgs(orgConverter.orgBOToDO(orgBO));
    }

    @Override
    public OrgDO querySingleOrg(QueryOrgReqDTO queryOrgReqDTO) {
        OrgBO orgBO = orgConverter.queryOrgDtoToBO(queryOrgReqDTO);
        return orgManager.querySingleOrg(orgConverter.orgBOToDO(orgBO));
    }

}
