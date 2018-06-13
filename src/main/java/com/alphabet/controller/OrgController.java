package com.alphabet.controller;

import com.alphabet.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private OrgService orgService;



}
