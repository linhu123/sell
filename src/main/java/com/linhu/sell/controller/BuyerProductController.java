package com.linhu.sell.controller;

import com.linhu.sell.VO.ProductVO;
import com.linhu.sell.VO.ProductinfoVO;
import com.linhu.sell.VO.ResultVO;
import com.linhu.sell.dataobject.ProductCategory;
import com.linhu.sell.dataobject.ProductInfo;
import com.linhu.sell.service.CategoryService;
import com.linhu.sell.service.ProductService;
import com.linhu.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
买家商品相关
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("list")
    public ResultVO list(){
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（一次性查询）
        //List<Integer> categoryTypeList =new ArrayList<>();
//        for (ProductInfo productinfo:productInfoList) {
//            categoryTypeList.add(productinfo.getCategoryType());
//        }
        //java8 lambda
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory proCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(proCategory.getCategoryName());
            productVO.setCategoryType(proCategory.getCategoryType());
            List<ProductinfoVO> productinfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if (productInfo.getCategoryType().equals(proCategory.getCategoryType())){
                    ProductinfoVO productinfoVO = new ProductinfoVO();
                    BeanUtils.copyProperties(productInfo,productinfoVO);
                    productinfoVOList.add(productinfoVO);
                }
            }
            productVO.setProductinfoVOList(productinfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
