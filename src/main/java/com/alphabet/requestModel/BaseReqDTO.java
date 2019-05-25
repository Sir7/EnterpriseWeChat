package com.alphabet.requestModel;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description 用户表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:17
 **/
@Setter
@Getter
@ToString(callSuper=true)
public class BaseReqDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 请求日志号
     */
    @NotNull(message = "日志号不能为空")
    private String traceLogid;

    /**
     * 请求系统
     */
    private String requestSystem;

}
