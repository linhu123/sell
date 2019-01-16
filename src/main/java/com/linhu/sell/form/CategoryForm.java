package com.linhu.sell.form;

import lombok.Data;

/**
 * 产品类目表单
 */
@Data
public class CategoryForm {
    private Integer categoryId;
    /*类目名字*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;
}
