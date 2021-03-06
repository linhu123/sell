package com.linhu.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功");
    private Integer code;
    private String message;
    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static PayStatusEnum getPayStatusEnum(Integer code){
        for (PayStatusEnum payStatusEnum:PayStatusEnum.values()) {
            if (payStatusEnum.code.equals(code))
                return payStatusEnum;
        }
        return null;
    }
}
