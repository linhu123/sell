package com.linhu.sell.service.impl;

import com.linhu.sell.dataobject.ProductCategory;
import com.linhu.sell.repository.ProductCategoryRepository;
import com.linhu.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository  repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categortTypeList) {
        return repository.findByCategoryTypeIn(categortTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
