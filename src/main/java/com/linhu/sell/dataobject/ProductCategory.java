package com.linhu.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//@DynamicUpdate可以自动更新修改时间
@Proxy(lazy = false)
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    /*类目id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer categoryId;
    /*类目名字*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;

//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public Integer getCategoryType() {
//        return categoryType;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public void setCategoryType(Integer categoryType) {
//        this.categoryType = categoryType;
//    }


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
