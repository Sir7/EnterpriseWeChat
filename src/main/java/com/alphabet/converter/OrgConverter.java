package com.alphabet.converter;

import com.alphabet.entity.OrgBOModel.OrgBO;
import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.model.requestModel.OrgReqDTO.*;
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

    /**
     * 修改ReqDto->BO
     * @param updateOrgReqDTO
     * @return
     */
    public static OrgBO updateOrgDtoToBO(UpdateOrgReqDTO updateOrgReqDTO){
        if(updateOrgReqDTO == null){
            return null;
        }
        OrgBO orgBO = OrgBO.builder().orgId(updateOrgReqDTO.getOrgId())
                .orgName(updateOrgReqDTO.getOrgName())
                .budgetunit(updateOrgReqDTO.getBudgetunit())
                .comments(updateOrgReqDTO.getComments())
                .parentId(updateOrgReqDTO.getParentId())
                .showOrder(updateOrgReqDTO.getShowOrder())
                .build();
        return orgBO;
    }

    /**
     * 查询ReqDto->BO
     * @param queryOrgsReqDTO
     * @return
     */
    public static OrgBO queryOrgsDtoToBO(QueryOrgsReqDTO queryOrgsReqDTO){
        if(queryOrgsReqDTO == null){
            return null;
        }
        OrgBO orgBO = OrgBO.builder().orgId(queryOrgsReqDTO.getOrgId())
                .orgName(queryOrgsReqDTO.getOrgName())
                .budgetunit(queryOrgsReqDTO.getBudgetunit())
                .comments(queryOrgsReqDTO.getComments())
                .parentId(queryOrgsReqDTO.getParentId())
                .showOrder(queryOrgsReqDTO.getShowOrder())
                .build();
        return orgBO;
    }

    /**
     * 查询ReqDto->BO
     * @param queryOrgReqDTO
     * @return
     */
    public static OrgBO queryOrgDtoToBO(QueryOrgReqDTO queryOrgReqDTO){
        if(queryOrgReqDTO == null){
            return null;
        }
        OrgBO orgBO = OrgBO.builder().orgId(queryOrgReqDTO.getOrgId())
                .orgName(queryOrgReqDTO.getOrgName())
                .budgetunit(queryOrgReqDTO.getBudgetunit())
                .comments(queryOrgReqDTO.getComments())
                .parentId(queryOrgReqDTO.getParentId())
                .showOrder(queryOrgReqDTO.getShowOrder())
                .build();
        return orgBO;
    }
}
