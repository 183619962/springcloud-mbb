package com.lupf.springboot.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 参数错误的传输对象
 */
@Data
@AllArgsConstructor
public class ParamErrDto {
    /**
     * 字段名
     */
    private String field;

    /**
     * 字段错误描述
     */
    private String message;
}
