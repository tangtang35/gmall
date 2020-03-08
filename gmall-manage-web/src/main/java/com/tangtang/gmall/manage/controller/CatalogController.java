package com.tangtang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tangtang.gmall.bean.BaseCatalog1;
import com.tangtang.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        List<BaseCatalog1> baseCatalog1List = catalogService.getCatalog1();
        return baseCatalog1List;
    }
}
