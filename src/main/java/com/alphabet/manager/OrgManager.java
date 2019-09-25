package com.alphabet.manager;

import com.alphabet.dal.OrgMapper;
import com.alphabet.entity.OrgDOModel.OrgDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yanglvsen
 * @version V1.0
 * @Title TODO
 * @Description TODO
 * @Package com.alphabet.manager
 * @date 2019/9/25 20:23
 */
@Component
public class OrgManager {

    public OrgManager(){}

    @Autowired
    private OrgMapper orgMapper;

    /**
     * 新增部门
     * @param orgDO
     * @return
     */
    public Boolean addOrg(OrgDO orgDO){
        return orgMapper.insert(orgDO) > 0;
    }

    /**
     * 修改部门
     * @param orgDO
     * @return
     */
    public Boolean modifyOrg(OrgDO orgDO){
        return orgMapper.update(orgDO) > 0;
    }

    /**
     * 获取单个部门
     * @param orgDO
     * @return
     */
    public Boolean delOrg(OrgDO orgDO){
        return orgMapper.del(orgDO) > 0;
    }

    /**
     * 获取单个部门
     * @param orgDO
     * @return
     */
    public OrgDO querySingleOrg(OrgDO orgDO){
        return orgMapper.querySingleOrg(orgDO);
    }

    /**
     * 获取多个部门
     * @param orgDO
     * @return
     */
    public List<OrgDO> queryOrgs(OrgDO orgDO){
        return orgMapper.queryOrgs(orgDO);
    }

}
