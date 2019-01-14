package com.linhu.sell.repository;

import com.linhu.sell.dataobject.OrderMaster;
import com.linhu.sell.enums.OrderStatusEnum;
import com.linhu.sell.enums.PayStatusEnum;
import com.linhu.sell.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void save(){
        //OrderMaster orderMaster = new OrderMaster("2","kankan","15527069589","户口社区","weixin1234",new BigDecimal(54), OrderStatusEnum.NEW.getCode(), PayStatusEnum.WAIT.getCode());
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(KeyUtil.genUniqueKey());
        orderMaster.setBuyerName("linhu");
        orderMaster.setBuyerOpenid("weix0099");
        orderMaster.setBuyerAddress("安徽省的空间");
        orderMaster.setBuyerPhone("12345678900");
        orderMaster.setOrderAmount(BigDecimal.valueOf(123));
        orderMasterRepository.save(orderMaster);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid("weixin123123",request);
        System.out.println("=================="+result.getTotalElements());
    }

}