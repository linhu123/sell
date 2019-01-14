package com.linhu.sell.service;

import com.linhu.sell.dto.OrderDTO;

/**
 * 买家
 * @Author: linhu
 * @Date: 2019/1/5 14:49
 * @Version 1.0
 */
public interface BuyerService {
    /**
     * 查询一个订单
     */
    OrderDTO findOrderOne(String openid,String orderId);
    /**
     * 取消订单
     */
    OrderDTO cancel(String openid,String orderId);

}
