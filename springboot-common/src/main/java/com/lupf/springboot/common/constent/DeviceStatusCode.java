package com.lupf.springboot.common.constent;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LENOVO
 * @title: DeviceStatusCode
 * @projectName springcloud-mbb
 * @description: TODO 设备相关的状态码
 * @date 2020/12/2 23:33
 */
@Getter
@AllArgsConstructor
public enum DeviceStatusCode implements IStatusCode{
    ERR_3000(3000,"设备id有误"),
    ERR_3001(3001,"设备名称格式错误"),
    ERR_3002(3002,"设备MAC地址无效")
    ;
    private Integer status;

    private String msg;
}
