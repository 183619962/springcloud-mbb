package com.lupf.springbootvalid.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.lupf.springboot.common.dto.BaseResponceDto;
import lombok.Data;

/**
 * 用户响应请求
 */
@Data
public class UserResponceDto {
    // 简单视图，只返回最基数的属性
    public interface UserResponceSimpleDtoView extends BaseResponceDto.ResponceBaseDtoView {};

    // 详情视图，返回详细的属性参数
    public interface UserResponceDetailDtoView extends UserResponceSimpleDtoView {};


    /**
     * 用户名
     */
    @JsonView(UserResponceSimpleDtoView.class)
    public String userName;

    /**
     * 年龄
     */
    @JsonView(UserResponceDetailDtoView.class)
    private Integer age;

    /**
     * 性别
     */
    @JsonView(UserResponceDetailDtoView.class)
    private Integer gender;

    /**
     * 邮箱
     */
    @JsonView(UserResponceDetailDtoView.class)
    private String email;

    /**
     * 电话号码
     */
    @JsonView(UserResponceSimpleDtoView.class)
    private String phoneNum;

    /**
     * 修改人
     */
    @JsonView(UserResponceDetailDtoView.class)
    private String optUser;
}
