package com.lupf.springboot.common.utils;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * @author LENOVO
 * @title: ResponseDataBody
 * @projectName springcloud-mbb
 * @description: TODO 规范响应数据的注解
 * @date 2020/12/1 15:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseDataBody {
}
