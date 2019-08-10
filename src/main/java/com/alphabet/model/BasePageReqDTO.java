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
@ToString(callSuper = true)
public class BasePageReqDTO extends BaseReqDTO implements Serializable{

    private static final long serialVersionUID = -7700550882677854432L;

    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    @NotBlank(message = "当前页不能为空值")
    private String currentPage;

    /**
     * 每页显示条数
     */
    @NotNull(message = "每页显示条数不能为空")
    @NotBlank(message = "每页显示条数不能为空值")
    private String pageSize;

}
