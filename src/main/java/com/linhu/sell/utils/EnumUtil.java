package com.linhu.sell.utils;

import com.linhu.sell.enums.CodeEnum;

/**
 * @Author: linhu
 * @Date: 2019/1/9 13:06
 * @Version 1.0
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
