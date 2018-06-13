package com.alphabet.service.impl;

import com.alphabet.dao.OrgDao;
import com.alphabet.entity.OrgEntity;
import com.alphabet.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:47
 **/
@Service("orgService")
public class OrgServiceImpl implements OrgService{

    @Autowired
    private OrgDao orgDao;

    @Override
    public List<OrgEntity> queryAllOrg() {
        return orgDao.queryAllOrg();
    }

    @Override
    public OrgEntity getOrgByOrgId(String orgId) {
        return orgDao.getOrgByOrgId(orgId);
    }

    @Override
    public OrgEntity getOrgById(String id) {
        return orgDao.getOrgById(id);
    }

    @Override
    public OrgEntity getOrgByName(String orgName) {
        return orgDao.getOrgByName(orgName);
    }
}
