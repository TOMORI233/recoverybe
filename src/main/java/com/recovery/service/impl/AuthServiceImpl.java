package com.recovery.service.impl;

import com.recovery.dao.AuthRepository;
import com.recovery.dto.LoginDto;
import com.recovery.entity.UserInfo;
import com.recovery.service.AuthService;
import com.recovery.util.JWTUtils;
import com.recovery.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthRepository authRepository;

    @Override
    public Result login(String userToken) {
        // parse token
        LoginDto loginDto = JWTUtils.parseToken(userToken);
        // authentication
        Optional<UserInfo> userOptional = authRepository.findByPhoneAndPassword(loginDto.getPhone(), loginDto.getPassword());
        Result result = new Result();
        result.setMessage("Login failed");
        userOptional.ifPresent(userInfo -> {
            result.setMessage("Login success");
            result.setData(userInfo);
        });
        return result;
    }
}
