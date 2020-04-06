package com.tangtang.gmall.service;

import com.tangtang.gmall.bean.BaseCatalog1;
import com.tangtang.gmall.bean.BaseCatalog2;
import com.tangtang.gmall.bean.BaseCatalog3;

import java.util.List;

public interface CatalogService {

    List<BaseCatalog1> getCatalog1();

    List<BaseCatalog2> getCatalog2(BaseCatalog2 baseCatalog2);

    List<BaseCatalog3> getCatalog3(BaseCatalog3 baseCatalog3);
}
