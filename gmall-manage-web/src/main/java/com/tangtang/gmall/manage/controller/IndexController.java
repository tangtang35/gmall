package com.tangtang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tangtang.gmall.bean.BaseAttrInfo;
import com.tangtang.gmall.bean.BaseAttrValue;
import com.tangtang.gmall.service.BaseAttrInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("attrListPage")
    public String getAttrListPage(){
        return "attrListPage";
    }


}
