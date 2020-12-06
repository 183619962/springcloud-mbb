package com.lupf.springbootvalid.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lupf.springboot.common.constent.BaseStatusCode;
import com.lupf.springboot.common.controller.BaseController;
import com.lupf.springboot.common.dto.BaseResponceDto;
import com.lupf.springboot.common.ex.BaseException;
import com.lupf.springboot.common.utils.ReturnUtils;
import com.lupf.springbootvalid.dto.UserRequestDto;
import com.lupf.springbootvalid.dto.UserResponceDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {


    @PostMapping("add")
    @JsonView(UserResponceDto.UserResponceSimpleDtoView.class)
    public BaseResponceDto add(@Validated(UserRequestDto.UserRequestDtoAddValidate.class) @RequestBody UserRequestDto userRequestDto) {
        UserResponceDto userResponceDto = new UserResponceDto();
        userResponceDto.setUserName("张三");
        userResponceDto.setAge(10);
        userResponceDto.setEmail("zhangsan@qq.com");

        return ReturnUtils.success(userResponceDto);
    }

    @PutMapping("update")
    public void update(@Validated(UserRequestDto.UserRequestDtoUpdateValidate.class) @RequestBody UserRequestDto userRequestDto) throws BaseException {
        throw new BaseException(BaseStatusCode.ERR_9999, "123456");
    }

    @GetMapping("getSimple")
    @JsonView(UserResponceDto.UserResponceSimpleDtoView.class)
    public UserResponceDto getSimple() {
        UserResponceDto userResponceDto = new UserResponceDto();
        userResponceDto.setUserName("张三");
        userResponceDto.setAge(10);
        userResponceDto.setEmail("zhangsan@qq.com");
        userResponceDto.setGender(0);
        userResponceDto.setPhoneNum("13888888888");
        userResponceDto.setOptUser("admin");

        return userResponceDto;
    }

    @GetMapping("getDetail")
    @JsonView(UserResponceDto.UserResponceDetailDtoView.class)
    public UserResponceDto getDetail() {
        UserResponceDto userResponceDto = new UserResponceDto();
        userResponceDto.setUserName("张三");
        userResponceDto.setAge(10);
        userResponceDto.setEmail("zhangsan@qq.com");
        userResponceDto.setGender(0);
        userResponceDto.setPhoneNum("13888888888");
        userResponceDto.setOptUser("admin");

        return userResponceDto;
    }
}
