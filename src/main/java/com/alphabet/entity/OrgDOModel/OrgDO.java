package com.alphabet.entity.OrgDOModel;

import lombok.Builder;
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
@Builder
public class OrgDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
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
}
