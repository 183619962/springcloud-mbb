package com.lupf.springbootvalid.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lupf.springboot.common.controller.BaseController;
import com.lupf.springboot.common.ex.BaseException;
import com.lupf.springbootvalid.dto.UserRequestDto;
import com.lupf.springbootvalid.dto.UserResponceDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user1")
public class User1Controller extends BaseController {

    @PostMapping("add")
    @JsonView(UserResponceDto.UserResponceSimpleDtoView.class)
    public UserResponceDto add(@Validated(UserRequestDto.UserRequestDtoAddValidate.class) @RequestBody UserRequestDto userRequestDto) {
        UserResponceDto userResponceDto = new UserResponceDto();
        userResponceDto.setUserName("张三");
        userResponceDto.setAge(10);
        userResponceDto.setEmail("zhangsan@qq.com");

        return userResponceDto;
    }

    @PutMapping("update")
    public void update(@Validated(UserRequestDto.UserRequestDtoUpdateValidate.class) @RequestBody UserRequestDto userRequestDto) throws BaseException {
        //throw new BaseException(HttpStatus.ACCEPTED, "123456");
    }

    @GetMapping("get")
    @JsonView(UserResponceDto.UserResponceDetailDtoView.class)
    public UserResponceDto get() {
        UserResponceDto userResponceDto = new UserResponceDto();
        userResponceDto.setUserName("李四");
        userResponceDto.setAge(20);
        userResponceDto.setEmail("lisi@qq.com");
        userResponceDto.setGender(0);
        userResponceDto.setPhoneNum("13888888888");

        return userResponceDto;
    }
}
