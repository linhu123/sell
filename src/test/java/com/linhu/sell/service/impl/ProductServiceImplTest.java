package com.linhu.sell.service.impl;

import com.linhu.sell.dataobject.ProductInfo;
import com.sun.xml.internal.ws.spi.ProviderImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findOne() {
        System.out.println(service.findOne("1234").toString());
    }

    @Test
    public void findUpAll() {
        for (ProductInfo info:service.findUpAll()
             ) {
            System.out.println(info.toString());
        }
    }

    @Test
    public void findAll( ) {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = service.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1236");
        productInfo.setProductName("海底捞");
        productInfo.setProductPrice(new BigDecimal(5.2));
        productInfo.setProductStock(3);
        productInfo.setProductDescription("我们服务超级棒");
        productInfo.setProductIcon("https://haidilao.jpg");
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(1);
        service.save(productInfo);
    }
}