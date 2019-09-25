package com.alphabet.model.requestModel.OrgReqDTO;

import com.alphabet.model.BaseReqDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description 部门修改请求DTO
 * @Author yang.lvsen
 * @Date 2018/6/6 15:18
 **/
@Setter
@Getter
@ToString(callSuper=true)
public class UpdateOrgReqDTO extends BaseReqDTO implements Serializable {

    private static final long serialVersionUID = -3048317612846173897L;
    /**
     * 部门ID
     */
    private String orgId;
    /**
     * 部门名称
     */
    @NotNull(message = "部门名称不能为空")
    @NotBlank(message = "部门名称不能为空值")
    private String orgName;
    /**
     * 上级部门ID
     */
    @NotNull(message = "上级部门ID不能为空")
    @NotBlank(message = "上级部门ID不能为空值")
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
    @NotNull(message = "部门名称不能为空")
    @NotBlank(message = "部门名称不能为空值")
    private String operator;
}
