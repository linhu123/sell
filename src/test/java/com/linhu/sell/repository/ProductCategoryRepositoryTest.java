package com.linhu.sell.repository;

import com.linhu.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private  ProductCategoryRepository repository;
    @Test
    public void findTest(){
        ProductCategory productCategory = repository.getOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    public void saveTest(){
        ProductCategory category = new ProductCategory();
        category.setCategoryName("女生最爱");
        category.setCategoryType(3);
        System.out.println(category.toString());
        repository.save(category);

    }
    @Test
    public void updateTest(){
        ProductCategory category = new ProductCategory();
        category.setCategoryId(2);
        category.setCategoryName("男生最爱");
        category.setCategoryType(3);
        System.out.println(category.toString());
        repository.save(category);

    }
}