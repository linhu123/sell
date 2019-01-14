package com.linhu.sell.service.impl;

import com.linhu.sell.dto.OrderDTO;
import com.linhu.sell.enums.ResultEnum;
import com.linhu.sell.exception.SellException;
import com.linhu.sell.service.BuyerService;
import com.linhu.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: linhu
 * @Date: 2019/1/5 14:51
 * @Version 1.0
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancel(String openid, String orderId) {
        OrderDTO orderDTO =  checkOrderOwner(openid,orderId);
        if (orderDTO == null){
            log.error("【取消订单】 查不到这个订单，orderId = {}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        return orderService.cancel(orderDTO);
    }

    public OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        //判断是否属于当前用户
        if (!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】 订单的openid不一致，openId = {},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);

        }
        return orderDTO;
    }
}
