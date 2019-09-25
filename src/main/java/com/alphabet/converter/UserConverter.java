package com.alphabet.converter;

import com.alphabet.entity.UserBOModel.UserBO;
import com.alphabet.entity.UserDOModel.UserDO;
import com.alphabet.model.requestModel.UserReqDTO.AddUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.DelUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.QueryUserReqDTO;
import com.alphabet.model.requestModel.UserReqDTO.UpdateUserReqDTO;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2019/5/25 21:37
 **/
@Component
public class UserConverter {

    public UserConverter(){}

    /**
     * 新增ReqDTO->AddBO
     * @param addUserReqDTO
     * @return
     */
    public static UserBO addUserReqDtoToBO(AddUserReqDTO addUserReqDTO){
        if(addUserReqDTO == null){
            return null;
        }
        UserBO userBO = UserBO.builder().userId(addUserReqDTO.getUserId())
                .userName(addUserReqDTO.getUserName())
                .birthday(addUserReqDTO.getBirthday())
                .comments(addUserReqDTO.getComments())
                .email(addUserReqDTO.getEmail())
                .isSuperadmin(addUserReqDTO.getIsSuperadmin())
                .loginName(addUserReqDTO.getLoginName())
                .mobile(addUserReqDTO.getMobilePhone())
                .orgId(addUserReqDTO.getOrgId())
                .orgName(addUserReqDTO.getOrgName())
                .policeId(addUserReqDTO.getPoliceId())
                .post(addUserReqDTO.getPost())
                .remark(addUserReqDTO.getRemark())
                .station(addUserReqDTO.getStation())
                .status(addUserReqDTO.getStatus())
                .telephone(addUserReqDTO.getTelephone())
                .urlPath(addUserReqDTO.getUrlPath())
                .build();
        return userBO;
    }

    public static UserDO userBOToDO(UserBO userBO){
        if(userBO == null){
            return null;
        }
        UserDO userDO = UserDO.builder().userId(userBO.getUserId())
                .userName(userBO.getUserName())
                .birthday(userBO.getBirthday())
                .comments(userBO.getComments())
                .email(userBO.getEmail())
                .isSuperadmin(userBO.getIsSuperadmin())
                .loginName(userBO.getLoginName())
                .mobile(userBO.getMobile())
                .orgId(userBO.getOrgId())
                .orgName(userBO.getOrgName())
                .policeId(userBO.getPoliceId())
                .post(userBO.getPost())
                .remark(userBO.getRemark())
                .station(userBO.getStation())
                .status(userBO.getStatus())
                .telephone(userBO.getTelephone())
                .urlPath(userBO.getUrlPath())
                .build();
        return userDO;
    }

    /**
     * 新增ReqDTO->AddBO
     * @param delUserReqDTO
     * @return
     */
    public static UserBO delUserReqDtoToBO(DelUserReqDTO delUserReqDTO){
        if(delUserReqDTO == null){
            return null;
        }
        UserBO userBO = UserBO.builder().userId(delUserReqDTO.getUserId()).build();
        return userBO;
    }

    /**
     * 查询ReqDTO->UserBO
     * @param queryUserReqDTO
     * @return
     */
    public static UserBO queryUserReqDtoToBO(QueryUserReqDTO queryUserReqDTO){
        if(queryUserReqDTO == null){
            return null;
        }
        UserBO userBO = UserBO.builder().userId(queryUserReqDTO.getUserId())
                .userName(queryUserReqDTO.getUserName())
                .birthday(queryUserReqDTO.getBirthday())
                .comments(queryUserReqDTO.getComments())
                .email(queryUserReqDTO.getEmail())
                .isSuperadmin(queryUserReqDTO.getIsSuperadmin())
                .loginName(queryUserReqDTO.getLoginName())
                .mobile(queryUserReqDTO.getMobile())
                .orgId(queryUserReqDTO.getOrgId())
                .orgName(queryUserReqDTO.getOrgName())
                .policeId(queryUserReqDTO.getPoliceId())
                .post(queryUserReqDTO.getPost())
                .remark(queryUserReqDTO.getRemark())
                .station(queryUserReqDTO.getStation())
                .status(queryUserReqDTO.getStatus())
                .telephone(queryUserReqDTO.getTelephone())
                .urlPath(queryUserReqDTO.getUrlPath())
                .build();
        return userBO;
    }

    /**
     * 修改ReqDTO->BO
     * @param updateUserReqDTO
     * @return
     */
    public static UserBO updateUserReqDtoToBO(UpdateUserReqDTO updateUserReqDTO){
        if(updateUserReqDTO == null){
            return null;
        }
        UserBO userBO = UserBO.builder().userId(updateUserReqDTO.getUserId())
                .userName(updateUserReqDTO.getUserName())
                .birthday(updateUserReqDTO.getBirthday())
                .comments(updateUserReqDTO.getComments())
                .email(updateUserReqDTO.getEmail())
                .isSuperadmin(updateUserReqDTO.getIsSuperadmin())
                .loginName(updateUserReqDTO.getLoginName())
                .mobile(updateUserReqDTO.getMobilePhone())
                .orgId(updateUserReqDTO.getOrgId())
                .orgName(updateUserReqDTO.getOrgName())
                .policeId(updateUserReqDTO.getPoliceId())
                .post(updateUserReqDTO.getPost())
                .remark(updateUserReqDTO.getRemark())
                .station(updateUserReqDTO.getStation())
                .status(updateUserReqDTO.getStatus())
                .telephone(updateUserReqDTO.getTelephone())
                .urlPath(updateUserReqDTO.getUrlPath())
                .build();
        return userBO;
    }

}
