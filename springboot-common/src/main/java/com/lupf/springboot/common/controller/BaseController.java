package com.lupf.springboot.common.controller;

import com.lupf.springboot.common.constent.BaseStatusCode;
import com.lupf.springboot.common.dto.ParamErrDto;
import com.lupf.springboot.common.ex.BaseException;
import com.lupf.springboot.common.utils.ResponseDataBody;
import com.lupf.springboot.common.utils.ReturnUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller的的基础对象
 * 所有的Controller都将继承自他
 */
@Slf4j
@ResponseDataBody
public class BaseController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object HttpMessageNotReadableExceptionHandler(HttpMessageNotReadableException httpMessageNotReadableException){
        log.error("捕获请求参数读取异常....",httpMessageNotReadableException);
        // 前端未传递参数 导致读取参数异常
        return ReturnUtils.error(BaseStatusCode.ERR_1000);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object bindExceptionHandler(BindException bindException){
        log.error("捕获请求参数校验异常....",bindException);
        // 获取到所有的校验失败的属性
        List<FieldError> fieldErrors = bindException.getFieldErrors();

        // 实例化一个用于装参数错误的list
        List<ParamErrDto> paramErrDtos = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            // 那段字段名
            String field = fieldError.getField();
            // 拿到异常的描述
            String defaultMessage = fieldError.getDefaultMessage();
            log.info("field:{} msg:{}", field, defaultMessage);
            // 添加到list中去
            paramErrDtos.add(new ParamErrDto(field, defaultMessage));
        }

        // 返回前端参数错误 并告诉前端那些字段不对 具体描述是什么
        return ReturnUtils.error(BaseStatusCode.ERR_1000, paramErrDtos);
    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object baseExceptionHandler(BaseException baseException){
        log.error("捕获到业务异常!",baseException);
        // 基础的业务异常
        return ReturnUtils.error(baseException);
    }

    /**
     * 通过ExceptionHandler 捕获controller未捕获到的异常，给用户一个友好的返回
     *
     * @param ex 异常信息
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Object exceptionHandler(Exception ex) {
        log.error("exceptionHandler....");
        // 所有的  自定义的、已知的异常全部都没有匹配上
        // 直接响应响应一个未知错误的提醒
        return ReturnUtils.error(BaseStatusCode.ERR_9999);
    }
}
