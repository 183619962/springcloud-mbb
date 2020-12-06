package com.lupf.springboot.common.constent;

/**
 * 错误码的接口
 */
public interface IStatusCode {
    /**
     * 获取状态码
     * @return 返回
     */
     Integer getStatus();

    /**
     * 获取状态描述
     * @return 返回描述信息
     */
     String getMsg();
}
