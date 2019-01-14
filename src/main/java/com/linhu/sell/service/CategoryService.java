package com.linhu.sell.service;

import com.linhu.sell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categortTypeList);

    ProductCategory save (ProductCategory productCategory);
}
