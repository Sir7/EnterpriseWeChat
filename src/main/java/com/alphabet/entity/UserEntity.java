package com.alphabet.entity;

/**
 * @Description 用户表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:17
 **/
public class UserEntity {

    private String id;
    private String userId;//用户ID
    private String userName;//用户名
    private String loginName;//登录名
    private String policeId;//工号
    private String post;//职务
    private String station;//岗位
    private String mobile;//手机号码
    private String telephone;//固定电话
    private String email;//邮件地址
    private String comments;//备注
    private String status;//状态
    private String orgId;//组织ID
    private String orgName;//组织名称
    private String birthday;//生日
    private String urlPath;//照片路径
    private String isSuperadmin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getIsSuperadmin() {
        return isSuperadmin;
    }

    public void setIsSuperadmin(String isSuperadmin) {
        this.isSuperadmin = isSuperadmin;
    }
}
