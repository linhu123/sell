package com.linhu.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.linhu.sell.dataobject.OrderDetail;
import com.linhu.sell.dto.OrderDTO;
import com.linhu.sell.enums.ResultEnum;
import com.linhu.sell.exception.SellException;
import com.linhu.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: linhu
 * @Date: 2019/1/5 11:27
 * @Version 1.0
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO converter(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string = {}",orderForm.getItems());
            throw new SellException(ResultEnum.FORM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
