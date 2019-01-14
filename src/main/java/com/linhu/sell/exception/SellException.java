package com.linhu.sell.exception;

import com.linhu.sell.enums.ResultEnum;

public class SellException extends RuntimeException {
    private Integer code;

    private String message;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code=code;
    }
}
