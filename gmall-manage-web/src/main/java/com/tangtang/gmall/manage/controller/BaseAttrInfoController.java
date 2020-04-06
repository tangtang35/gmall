package com.tangtang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tangtang.gmall.bean.BaseAttrInfo;
import com.tangtang.gmall.service.BaseAttrInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class BaseAttrInfoController {

    @Reference
    BaseAttrInfoService baseAttrInfoService;

    @RequestMapping("getAttrListByCtg3")
    @ResponseBody
    public List<BaseAttrInfo> getAttrListByCtg3(@RequestParam Map<String, String> map){
        String catalog3Id = map.get("catalog3Id");
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoService.getAttrListByCtg3(baseAttrInfo);
        return baseAttrInfoList;
    }
}
