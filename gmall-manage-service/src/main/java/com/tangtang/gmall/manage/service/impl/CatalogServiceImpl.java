package com.tangtang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tangtang.gmall.bean.BaseCatalog1;
import com.tangtang.gmall.bean.BaseCatalog2;
import com.tangtang.gmall.bean.BaseCatalog3;
import com.tangtang.gmall.manage.mapper.BaseCatalog1Mapper;
import com.tangtang.gmall.manage.mapper.BaseCatalog2Mapper;
import com.tangtang.gmall.manage.mapper.BaseCatalog3Mapper;
import com.tangtang.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;

    @Autowired
    BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    BaseCatalog3Mapper baseCatalog3Mapper;

    @Override
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getCatalog2(BaseCatalog2 baseCatalog2) {
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> getCatalog3(BaseCatalog3 baseCatalog3) {
        return baseCatalog3Mapper.select(baseCatalog3);
    }
}
