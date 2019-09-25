package com.alphabet.controller;

import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.model.requestModel.OrgReqDTO.*;
import com.alphabet.service.OrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OrgController
 * @Description TODO
 * @Author yang.lvsen
 * @Date 2018/6/6 21:38
 **/
@Slf4j
@RestController
@ResponseBody
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    /**
     * 新增部门
     *
     * @param addOrgReqDTO
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String AddOrg(AddOrgReqDTO addOrgReqDTO) {
        try {
            log.info("新增部门请求参数{}", addOrgReqDTO);
            Boolean aBoolean = orgService.addOrg(addOrgReqDTO);
            log.info("新增部门请求参数，返回结果：{}", aBoolean);
        } catch (Exception e) {
            log.error("新增部门请求参数失败，异常信息：{}", e);
        }
        return null;
    }

    /**
     * 删除部门
     *
     * @param delOrgReqDTO
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delOrg(DelOrgReqDTO delOrgReqDTO) {
        try {
            log.info("删除部门请求参数{}", delOrgReqDTO);
            Boolean aBoolean = orgService.delOrg(delOrgReqDTO);
            log.info("删除部门请求参数，返回结果：{}", aBoolean);
        } catch (Exception e) {
            log.error("删除部门请求参数失败，异常信息：{}", e);
        }
        return null;
    }

    /**
     * 修改部门
     *
     * @param updateOrgReqDTO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateOrg(UpdateOrgReqDTO updateOrgReqDTO) {
        try {
            log.info("修改部门请求参数{}", updateOrgReqDTO);
            Boolean aBoolean = orgService.updateOrg(updateOrgReqDTO);
            log.info("修改部门请求参数，返回结果：{}", aBoolean);
        } catch (Exception e) {
            log.error("修改部门请求参数失败，异常信息：{}", e);
        }
        return null;
    }

    /**
     * 获取多个部门
     *
     * @return
     */
    @RequestMapping(value = "/queryOrgs", method = RequestMethod.POST)
    public String queryOrgs(QueryOrgsReqDTO queryOrgsReqDTO) {
        try {
            log.info("获取多个部门");
            List<OrgDO> list = orgService.queryOrgs(queryOrgsReqDTO);
            log.info("获取多个部门，返回结果：{}", list);
        } catch (Exception e) {
            log.error("获取多个部门失败，异常信息：{}", e);
        }
        return null;
    }

    /**
     * 获取单个部门
     * @param queryOrgReqDTO
     * @return
     */
    @RequestMapping(value = "/querySingle", method = RequestMethod.POST)
    public String querySingleOrg(QueryOrgReqDTO queryOrgReqDTO) {
        try {
            log.info("获取单个部门");
            OrgDO orgDO = orgService.querySingleOrg(queryOrgReqDTO);
            log.info("获取单个部门，返回结果：{}", orgDO);
        } catch (Exception e) {
            log.error("获取单个部门失败，异常信息：{}", e);
        }
        return null;
    }

}
