package com.alphabet.service.impl;

import com.alphabet.conver.OrgConver;
import com.alphabet.entity.OrgBOModel.OrgBO;
import com.alphabet.manager.OrgMapper;
import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.requestModel.OrgModel.AddOrgReqDTO;
import com.alphabet.requestModel.OrgModel.DelOrgReqDTO;
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
    private OrgMapper orgMapper;
    @Autowired
    private OrgConver orgConver;

    /**
     * 新增部门
     * @param addOrgReqDTO
     * @return
     */
    @Override
    public Boolean addOrg(AddOrgReqDTO addOrgReqDTO) {
        OrgBO orgBO = orgConver.orgReqDtoToBO(addOrgReqDTO);
        OrgDO orgDO = orgConver.orgBOToDO(orgBO);
        Boolean aBoolean = orgMapper.del(orgDO) > 0;
        return aBoolean;
    }

    /**
     * 删除部门
     * @param delOrgReqDTO
     * @return
     */
    @Override
    public Boolean delOrg(DelOrgReqDTO delOrgReqDTO) {
        OrgBO orgBO = orgConver.delOrgDtoToBO(delOrgReqDTO);
        OrgDO orgDO = orgConver.orgBOToDO(orgBO);
        Boolean aBoolean = orgMapper.insert(orgDO) > 0;
        return aBoolean;
    }

    @Override
    public List<OrgDO> queryAllOrg() {
        return orgMapper.queryAllOrg();
    }

    @Override
    public OrgDO getOrgByOrgId(String orgId) {
        return orgMapper.getOrgByOrgId(orgId);
    }

    @Override
    public OrgDO getOrgById(String id) {
        return orgMapper.getOrgById(id);
    }

    @Override
    public OrgDO getOrgByName(String orgName) {
        return orgMapper.getOrgByName(orgName);
    }

}
