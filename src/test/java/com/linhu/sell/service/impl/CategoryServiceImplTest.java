package com.linhu.sell.service.impl;

import com.linhu.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl service;
    @Test
    public void findOne() {
        ProductCategory productCategory = service.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = service.findAll();
        for (ProductCategory item:list) {
            System.out.println(item);
        }


    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = service.findByCategoryTypeIn(Arrays.asList(1,2));
        for (ProductCategory item:list
             ) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void save() {
    }
}