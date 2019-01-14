package com.linhu.sell.repository;

import com.linhu.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("001");
        orderDetail.setOrderId("1234");
        orderDetail.setProductIcon("https://111.jpg");
        orderDetail.setProductId("123123");
        orderDetail.setProductName("老婆饼");
        orderDetail.setProductPrice(new BigDecimal(43));
        orderDetail.setProductQuantity(100);
        repository.save(orderDetail);
    }


}