package com.linhu.sell.service.impl;

import com.linhu.sell.dataobject.OrderDetail;
import com.linhu.sell.dto.OrderDTO;
import com.linhu.sell.enums.OrderStatusEnum;
import com.linhu.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    private String BUYER_OPENID = "ew3euwhd7sjw9diwkq";
    private String ORDER_ID = "1546668070640955922";

    @Test
    public void create20(){
        for(int i =0 ;i<20;i++){
            create();
        }
    }
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("临湖");
        orderDTO.setBuyerAddress("湖北第二师范学院");
        orderDTO.setBuyerPhone("123123123123");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1234");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}",result);

    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result = {}",result);

    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        System.out.println("------------------------------");
//        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        System.out.println(orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCLE.getCode(),result.getOrderStatus());


    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());

    }

    @Test
    public void list(){
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        System.out.println("------------------------------");
//        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        System.out.println(orderDTOPage.getTotalElements());
    }
}