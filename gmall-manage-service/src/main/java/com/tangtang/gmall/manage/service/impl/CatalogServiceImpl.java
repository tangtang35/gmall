package com.tangtang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tangtang.gmall.bean.BaseCatalog1;
import com.tangtang.gmall.manage.mapper.BaseCatalog1Mapper;
import com.tangtang.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;

    @Override
    public List<BaseCatalog1> getCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }
}
