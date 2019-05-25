package com.alphabet.requestModel.UserModel;


import com.alphabet.requestModel.BaseReqDTO;
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
public class DelUserReqDTO extends BaseReqDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

}
