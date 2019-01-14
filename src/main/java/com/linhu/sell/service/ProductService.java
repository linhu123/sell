package com.linhu.sell.service;

import com.linhu.sell.dataobject.ProductInfo;
import com.linhu.sell.dto.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productInfo);

//    List<ProductInfo> findByProductStatus(Integer  );
    /*
    * 查询所有在架商品列表
    * */
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CarDTO> carDTOList);

    //减库存
    void decreaseStock(List<CarDTO> carDTOList);
}
