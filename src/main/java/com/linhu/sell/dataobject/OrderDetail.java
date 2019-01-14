package com.linhu.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Proxy(lazy = false)
public class OrderDetail {

    @Id
    private String detailId;
    /*
    订单ID
     */
    private String orderId;
    /*
    商品ID
     */
    private String productId;
    /*
    商品名称
     */
    private String productName;
    /*
    单价
     */
    private BigDecimal productPrice;
    /*
    商品数量
     */
    private Integer productQuantity;
    /*
    商品小图
     */
    private String productIcon;

}
