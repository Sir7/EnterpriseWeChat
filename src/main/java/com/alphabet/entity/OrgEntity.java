package com.alphabet.entity;

/**
 * @Description 组织部门表
 * @Author yang.lvsen
 * @Date 2018/6/6 15:18
 **/
public class OrgEntity {

    private String orgId;//组织ID
    private String orgName;//组织名称
    private String parentId;//父节点ID
    private String comments;//备注
    private String budgetunit;//预算单位
    private String showOrder;//排序

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBudgetunit() {
        return budgetunit;
    }

    public void setBudgetunit(String budgetunit) {
        this.budgetunit = budgetunit;
    }

    public String getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(String showOrder) {
        this.showOrder = showOrder;
    }
}
