package com.alphabet.service.impl;

import com.alphabet.converter.OrgConverter;
import com.alphabet.entity.OrgBOModel.OrgBO;
import com.alphabet.manager.OrgMapper;
import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.model.requestModel.OrgReqDTO.AddOrgReqDTO;
import com.alphabet.model.requestModel.OrgReqDTO.DelOrgReqDTO;
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
        aBoolean = orgMapper.del(orgDO) > 0;
        return aBoolean;
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
        aBoolean = orgMapper.insert(orgDO) > 0;
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
