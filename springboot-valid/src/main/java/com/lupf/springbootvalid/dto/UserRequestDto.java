package com.lupf.springbootvalid.dto;

import com.lupf.springboot.common.utils.validator.CaseCheck;
import com.lupf.springboot.common.utils.validator.CaseMode;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserRequestDto {
    // 基础的校验接口，标识着所有操作都需要校验的字段
    public interface UserRequestDtoSimpleValidate {};

    // 修改的校验；继承自UserRequestDtoSimpleValidate 也就是说指定为这个组的时候在满足当前足校验规则的同事还得满足simole接口
    public interface UserRequestDtoUpdateValidate extends UserRequestDtoSimpleValidate {}

    // 原理同上
    public interface UserRequestDtoAddValidate extends UserRequestDtoUpdateValidate {}

    /**
     * 用户名
     */
    @NotBlank(message = "姓名不能为空",groups = UserRequestDtoSimpleValidate.class)
    @CaseCheck(value = CaseMode.UPPER,message = "用户名必须大写字母",groups = UserRequestDtoSimpleValidate.class)
    public String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空",groups = UserRequestDtoAddValidate.class)
    public String passWord;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空",groups = UserRequestDtoSimpleValidate.class)
    @Min(value = 0,message = "年龄不能小于0岁",groups = UserRequestDtoSimpleValidate.class)
    @Max(value = 120,message = "年龄不能大于120岁",groups = UserRequestDtoSimpleValidate.class)
    private Integer age;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空",groups = UserRequestDtoAddValidate.class)
    @Email(message = "邮箱格式不对",groups = UserRequestDtoAddValidate.class)
    private String email;

    /**
     * 电话号码
     */
    @NotBlank(message = "手机号不能为空",groups = UserRequestDtoAddValidate.class)
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$", message = "号码格式不正确!")
    private String phoneNum;

    /**
     * 修改人
     */
    @NotBlank(message = "操作人不能为空",groups = UserRequestDtoUpdateValidate.class)
    private String optUser;
}
