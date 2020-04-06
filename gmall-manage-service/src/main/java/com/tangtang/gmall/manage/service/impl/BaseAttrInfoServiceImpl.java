package com.tangtang.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tangtang.gmall.bean.BaseAttrInfo;
import com.tangtang.gmall.bean.BaseCatalog1;
import com.tangtang.gmall.bean.BaseCatalog2;
import com.tangtang.gmall.bean.BaseCatalog3;
import com.tangtang.gmall.manage.mapper.BaseAttrInfoMapper;
import com.tangtang.gmall.manage.mapper.BaseCatalog1Mapper;
import com.tangtang.gmall.manage.mapper.BaseCatalog2Mapper;
import com.tangtang.gmall.manage.mapper.BaseCatalog3Mapper;
import com.tangtang.gmall.service.BaseAttrInfoService;
import com.tangtang.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BaseAttrInfoServiceImpl implements BaseAttrInfoService {

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Override
    public List<BaseAttrInfo> getAttrListByCtg3(BaseAttrInfo baseAttrInfo) {
        return baseAttrInfoMapper.select(baseAttrInfo);
    }
}
