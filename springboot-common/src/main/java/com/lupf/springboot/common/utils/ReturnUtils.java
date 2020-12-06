package com.lupf.springboot.common.utils;

import com.lupf.springboot.common.constent.BaseStatusCode;
import com.lupf.springboot.common.dto.BaseResponceDto;
import com.lupf.springboot.common.ex.BaseException;
import org.springframework.http.HttpStatus;

/**
 * 响应帮助类
 */
public class ReturnUtils {

    /**
     * 响应成功
     *
     * @return
     */
    public static BaseResponceDto<Void> success() {
        return new BaseResponceDto(BaseStatusCode.SUCCESS);
    }

    /**
     * 根据Http状态码返回
     *
     * @return 基础的响应对象
     */
    public static BaseResponceDto<Void> successByHttpStatus() {
        return new BaseResponceDto(HttpStatus.OK);
    }

    /**
     * 根据自定义的状态码返回
     * 有响应数据的成功
     *
     * @param data 响应的数据
     * @param <T>  响应的数据类型
     * @return 基础的响应对象
     */
    public static <T> BaseResponceDto success(T data) {
        return new BaseResponceDto<T>(BaseStatusCode.SUCCESS, data);
    }

    /**
     * 根据http状态码返回
     *
     * @param data 响应的数据
     * @param <T>  响应的数据类型
     * @return 基础的响应对象
     */
    public static <T> BaseResponceDto successByHttpStatus(T data) {
        return new BaseResponceDto<T>(HttpStatus.OK, data);
    }

    /**
     * 没有响应数据的失败
     *
     * @param statusCode 状态码
     * @return
     */
    public static BaseResponceDto<Void> error(BaseStatusCode statusCode) {
        return new BaseResponceDto(statusCode);
    }

    /**
     * 有响应数据的失败
     *
     * @param statusCode 状态码
     * @param data       数据
     * @return
     */
    public static <T> BaseResponceDto error(BaseStatusCode statusCode, T data) {
        return new BaseResponceDto<T>(statusCode, data);
    }

    /**
     * 异常后的响应
     *
     * @param baseException 异常
     * @return
     */
    public static BaseResponceDto error(BaseException baseException) {
        return new BaseResponceDto(baseException);
    }
}
