package com.linhu.sell.repository;

import com.linhu.sell.dataobject.OrderDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String buyerOpenid, Pageable pageable);
    List<OrderDetail> findByOrderId(String buyerOpenid);

}
