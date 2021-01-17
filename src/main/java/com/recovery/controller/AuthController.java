package com.recovery.controller;

import com.recovery.service.impl.AuthServiceImpl;
import com.recovery.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户权限")
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthServiceImpl authService;

    @PostMapping(value = "/login")
    public Result userLogin(@RequestParam(value = "userToken") String userToken) {
        return authService.login(userToken);
    }

}
