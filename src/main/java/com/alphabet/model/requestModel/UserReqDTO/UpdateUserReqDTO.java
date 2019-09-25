package com.alphabet.model.requestModel.UserReqDTO;

import com.alphabet.model.BaseReqDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * @Description 用户表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:17
 **/
@Setter
@Getter
@ToString(callSuper=true)
public class UpdateUserReqDTO extends BaseReqDTO implements Serializable{

    private static final long serialVersionUID = -4781276340621801504L;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    private String userName;
    /**
     * 登录名
     */
    @NotNull(message = "登录名不能为空")
    @NotBlank(message = "登录名不能为空")
    private String loginName;
    /**
     * 工号
     */
    private String policeId;
    /**
     * 职务
     */
    @NotNull(message = "职务不能为空")
    @NotBlank(message = "职务不能为空")
    private String post;
    /**
     * 岗位
     */
    private String station;
    /**
     * 手机号码
     */
    @NotNull(message = "手机号码不能为空")
    @NotBlank(message = "手机号码不能为空")
    private String mobilePhone;
    /**
     * 固定电话
     */
    private String telephone;
    /**
     * 邮件地址
     */
    @NotNull(message = "邮件地址不能为空")
    @NotBlank(message = "邮件地址不能为空")
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
     * 出生年月日
     */
    @NotNull(message = "出生年月日不能为空")
    @NotBlank(message = "出生年月日不能为空")
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
