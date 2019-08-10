package com.alphabet.enums;

import lombok.Getter;
import org.apache.commons.lang.StringUtils;

/**
 * @author yanglvsen
 * @version V1.0
 * @Title TODO
 * @Description 用户状态枚举
 * @Package com.alphabet.enums
 * @date 2019/8/10 22:06
 */
@Getter
public enum UserStatusEnum {

    ENABLE("ENABLE","可用"),
    DISABLE("DISABLE","不可用");

    private String code;
    /**
     * 描述
     */
    private String desc;

    UserStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取desc
     * @param code
     * @return
     */
    public static String getValueByCode(String code){
        for(UserStatusEnum userStatusEnum : UserStatusEnum.values()){
            if(StringUtils.equals(code,userStatusEnum.getCode())){
                return userStatusEnum.getDesc();
            }
        }
        return  null;
    }

}
