package com.alphabet.entity;


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
public class BaseBO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 请求系统
     */
    private String requestSystem;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    private String updatedAt;
    /**
     * 更新人
     */
    private String updatedBy;
}
