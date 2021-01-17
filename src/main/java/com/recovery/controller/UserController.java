package com.recovery.controller;

import com.recovery.service.impl.UserServiceImpl;
import com.recovery.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户权限")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
}
