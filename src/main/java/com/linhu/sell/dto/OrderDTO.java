package com.linhu.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.linhu.sell.dataobject.OrderDetail;
import com.linhu.sell.enums.OrderStatusEnum;
import com.linhu.sell.enums.PayStatusEnum;
import com.linhu.sell.utils.EnumUtil;
import com.linhu.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@JsonSerialize(include = Js)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /*点单id*/
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家手机号*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家微信*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal orderAmount;
    /*订单状态*/
    private Integer orderStatus;
    /*支付状态*/
    private Integer payStatus;
    /*订单创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

    private List<OrderDetail> orderDetailList = new ArrayList<>();

}
