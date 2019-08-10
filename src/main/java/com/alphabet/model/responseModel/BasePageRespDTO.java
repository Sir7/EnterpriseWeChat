package com.alphabet.model.responseModel;


import lombok.ToString;

import java.io.Serializable;

/**
 * @Description 用户表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:17
 **/
@ToString(callSuper = true)
public class BasePageRespDTO extends BaseRespDTO implements Serializable{

    private static final long serialVersionUID = 986226278258751997L;
    /**
     * 当前页
     */
    private String currentPage;

    /**
     * 每页显示条数
     */
    private String pageSize;

}
