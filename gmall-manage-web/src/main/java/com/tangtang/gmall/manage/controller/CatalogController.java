package com.tangtang.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tangtang.gmall.bean.BaseCatalog1;
import com.tangtang.gmall.bean.BaseCatalog2;
import com.tangtang.gmall.bean.BaseCatalog3;
import com.tangtang.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(@RequestParam Map<String, String> map){
        String catalog2Id = map.get("catalog2Id");
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        List<BaseCatalog3> baseCatalog3List = catalogService.getCatalog3(baseCatalog3);
        return baseCatalog3List;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(@RequestParam Map<String, String> map){
        String catalog1Id = map.get("catalog1Id");
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        List<BaseCatalog2> baseCatalog2List = catalogService.getCatalog2(baseCatalog2);
        return baseCatalog2List;
    }

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        List<BaseCatalog1> baseCatalog1List = catalogService.getCatalog1();
        return baseCatalog1List;
    }
}
