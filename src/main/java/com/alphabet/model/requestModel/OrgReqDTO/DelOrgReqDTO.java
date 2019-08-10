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
public class DelOrgReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    private String orgId;
}
