package com.alphabet.requestModel.OrgModel;

import com.alphabet.requestModel.BaseReqDTO;
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
public class AddOrgReqDTO extends BaseReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    private String orgId;
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 备注
     */
    private String comments;
    /**
     * 预算单位
     */
    private String budgetunit;
    /**
     * 排序
     */
    private String showOrder;
    /**
     * 备注
     */
    private String remark;
    /**
     * 操作人
     */
    private String operator;
}
