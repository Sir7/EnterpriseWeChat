package com.alphabet.converter;

import com.alphabet.entity.OrgBOModel.OrgBO;
import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.requestModel.OrgModel.AddOrgReqDTO;
import com.alphabet.requestModel.OrgModel.DelOrgReqDTO;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2019/5/25 21:37
 **/
@Component
public class OrgConverter {

    public OrgConverter(){}

    /**
     * 新增ReqDto->BO
     * @param addOrgReqDTO
     * @return
     */
    public static OrgBO orgReqDtoToBO(AddOrgReqDTO addOrgReqDTO){
        if(addOrgReqDTO == null){
            return null;
        }
        OrgBO orgBO = OrgBO.builder().orgId(addOrgReqDTO.getOrgId())
                .orgName(addOrgReqDTO.getOrgName())
                .budgetunit(addOrgReqDTO.getBudgetunit())
                .comments(addOrgReqDTO.getComments())
                .parentId(addOrgReqDTO.getParentId())
                .showOrder(addOrgReqDTO.getShowOrder())
                .build();
        return orgBO;
    }

    /**
     * BO->DO
     * @param orgBO
     * @return
     */
    public static OrgDO orgBOToDO(OrgBO orgBO){
        if(orgBO == null){
            return null;
        }
        OrgDO orgDO = OrgDO.builder().orgId(orgBO.getOrgId())
                .orgName(orgBO.getOrgName())
                .budgetunit(orgBO.getBudgetunit())
                .comments(orgBO.getComments())
                .parentId(orgBO.getParentId())
                .showOrder(orgBO.getShowOrder())
                .build();
        return orgDO;
    }

    /**
     * 删除DTO-BO
     * @param delOrgReqDTO
     * @return
     */
    public static OrgBO delOrgDtoToBO(DelOrgReqDTO delOrgReqDTO){
        if(delOrgReqDTO == null){
            return null;
        }
        OrgBO orgBO = OrgBO.builder().orgId(delOrgReqDTO.getOrgId()).build();
        return orgBO;
    }

}
