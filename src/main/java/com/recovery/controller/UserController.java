package com.recovery.controller;

import com.recovery.dto.UserInfoAlterDto;
import com.recovery.service.impl.UserServiceImpl;
import com.recovery.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户信息管理")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @ApiOperation(value = "创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sex", dataType = "int", value = "0-未知,1-男,2-女", required = true, defaultValue = "0", example = "0")
    })
    @PostMapping("/new")
    public Result createUser(@RequestParam(value = "userID") String userID, Integer sex) {
        return userService.createUser(userID, sex);
    }

    @ApiOperation(value = "查询个人信息")
    @GetMapping("/info")
    public Result getUserInfo(@RequestParam(value = "userID") String userID) {
        return userService.getUserInfo(userID);
    }

    @ApiOperation(value = "修改个人信息")
    @PostMapping("/info")
    public Result alterUserInfo(@RequestBody UserInfoAlterDto userInfoAlterDto) {
        return userService.alterUserInfo(userInfoAlterDto);
    }
}
