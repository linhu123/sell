package com.linhu.sell.dataobject;

import com.linhu.sell.enums.OrderStatusEnum;
import com.linhu.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate  //自己更新修改时间
@Proxy(lazy = false)
public class OrderMaster {
    /*点单id*/
    @Id
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
    /*订单状态 默认为新订单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /*支付状态  默认 未支付  0*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /*
    订单创建时间
     */
    private Date createTime;
    /*
    更新时间
     */
    private Date updateTime;
//    @Transient  //数据库对应时会忽略
//    private List<OrderDetail> orderDetailList;

}
