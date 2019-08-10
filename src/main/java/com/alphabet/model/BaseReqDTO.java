package com.alphabet.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description 用户表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:17
 **/
@Setter
@Getter
@ToString
public class BaseReqDTO implements Serializable{

    private static final long serialVersionUID = -6133559415243092069L;
    /**
     * 请求日志号
     */
    @NotNull(message = "日志号不能为空")
    @NotBlank(message = "日志号不能为空值")
    private String traceLogId;

    /**
     * 请求系统
     */
    private String requestSystem;

}
