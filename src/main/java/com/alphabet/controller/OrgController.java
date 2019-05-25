package com.alphabet.controller;

import com.alphabet.entity.OrgDOModel.OrgDO;
import com.alphabet.requestModel.OrgModel.AddOrgReqDTO;
import com.alphabet.requestModel.OrgModel.DelOrgReqDTO;
import com.alphabet.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RestController
@ResponseBody
@RequestMapping("org")
public class OrgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrgController.class);

    @Autowired
    private OrgService orgService;

    /**
     * 新增部门
     * @param addOrgReqDTO
     * @return
     */
    @RequestMapping(value = "/addOrg", method = RequestMethod.POST)
    public String AddOrg(AddOrgReqDTO addOrgReqDTO){
        try{
            LOGGER.info("新增部门请求参数{}", addOrgReqDTO);
            Boolean aBoolean = orgService.addOrg(addOrgReqDTO);
            LOGGER.info("新增部门请求参数，返回结果：{}",aBoolean);
        }catch (Exception e){
            LOGGER.error("新增部门请求参数失败，异常信息：{}",e);
        }
        return null;
    }

    /**
     * 删除部门
     * @param delOrgReqDTO
     * @return
     */
    @RequestMapping(value = "/addOrg", method = RequestMethod.POST)
    public String delOrg(DelOrgReqDTO delOrgReqDTO){
        try{
            LOGGER.info("删除部门请求参数{}", delOrgReqDTO);
            Boolean aBoolean = orgService.delOrg(delOrgReqDTO);
            LOGGER.info("删除部门请求参数，返回结果：{}",aBoolean);
        }catch (Exception e){
            LOGGER.error("删除部门请求参数失败，异常信息：{}",e);
        }
        return null;
    }

    /**
     * 获取所有部门
     * @return
     */
    @RequestMapping(value = "/queryAllOrg",method = RequestMethod.POST)
    public String queryAllOrg(){
        try{
            LOGGER.info("获取所有部门");
            List<OrgDO> list = orgService.queryAllOrg();
            LOGGER.info("获取所有部门，返回结果：{}",list);
        }catch (Exception e){
            LOGGER.error("获取所有部门失败，异常信息：{}",e);
        }
        return null;
    }

}
