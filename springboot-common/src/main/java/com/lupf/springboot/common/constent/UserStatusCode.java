package com.lupf.springboot.common.constent;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LENOVO
 * @title: UserStatusCode
 * @projectName springcloud-mbb
 * @description: TODO 用户相关的状态码
 * @date 2020/12/2 23:30
 */
@Getter
@AllArgsConstructor
public enum UserStatusCode implements IStatusCode{
    ERR_2000(2000,"用户信息不存在"),

    ERR_2001(2001,"用户昵称格式错误")
    ;
    private Integer status;

    private String msg;
}
