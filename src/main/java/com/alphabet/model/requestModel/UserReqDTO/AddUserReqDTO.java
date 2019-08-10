package com.alphabet.model.requestModel.UserReqDTO;

import com.alphabet.model.BaseReqDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description 用户表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:17
 **/
@Setter
@Getter
@ToString(callSuper=true)
public class AddUserReqDTO extends BaseReqDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 工号
     */
    private String policeId;
    /**
     * 职务
     */
    private String post;
    /**
     * 岗位
     */
    private String station;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 固定电话
     */
    private String telephone;
    /**
     * 邮件地址
     */
    private String email;
    /**
     * 备注
     */
    private String comments;
    /**
     * 状态
     */
    private String status;
    /**
     * 组织ID
     */
    private String orgId;
    /**
     * 组织名称
     */
    private String orgName;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 照片路径
     */
    private String urlPath;
    /**
     * 是否是超管
     */
    private String isSuperadmin;
    /**
     * 备注
     */
    private String remark;
}
