package com.linhu.sell.service.impl;

import com.linhu.sell.dataobject.ProductInfo;
import com.linhu.sell.dto.CarDTO;
import com.linhu.sell.enums.ProductStatusEnum;

import com.linhu.sell.enums.ResultEnum;
import com.linhu.sell.exception.SellException;
import com.linhu.sell.repository.ProductInfoRepository;
import com.linhu.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productInfo) {
        return repository.getOne(productInfo);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO:carDTOList) {
            ProductInfo productInfo = repository.getOne(carDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + carDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO:carDTOList) {
            ProductInfo productInfo = repository.getOne(carDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - carDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
