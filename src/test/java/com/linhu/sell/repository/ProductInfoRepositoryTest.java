package com.linhu.sell.repository;

import com.linhu.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123511");
        productInfo.setProductName("老婆饼111");
        productInfo.setProductPrice(new BigDecimal(5.2));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("老婆做的的饼");
        productInfo.setProductIcon("https://laopobing.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(1);
        repository.save(productInfo);
    }
    @Test
    public void findProductByStatus(){
        List<ProductInfo> list = repository.findByProductStatus(0);
        for (ProductInfo info :list
             ) {
            System.out.println(info.toString());
        }
    }
}