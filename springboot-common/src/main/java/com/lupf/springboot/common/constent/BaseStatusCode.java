package com.lupf.springboot.common.constent;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 自定义的基础的状态码
 */
@Getter
@AllArgsConstructor
public enum BaseStatusCode implements IStatusCode {
    SUCCESS(200,"成功!"),

    ERR_1000(1000,"参数错误!"),

    ERR_9999(9999,"未知错误!")
    ;
    private Integer status;

    private String msg;
}
