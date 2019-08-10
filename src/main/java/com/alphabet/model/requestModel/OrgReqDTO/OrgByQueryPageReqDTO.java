package com.alphabet.model.requestModel.OrgReqDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description 组织部门表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:18
 **/
@Setter
@Getter
@ToString(callSuper=true)
public class OrgByQueryPageReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orgId;//组织ID
    private String orgName;//组织名称
    private String parentId;//父节点ID
    private String comments;//备注
    private String budgetunit;//预算单位
    private String showOrder;//排序
}
