package com.recovery.service.impl;

import com.recovery.dto.UserInfoDto;
import com.recovery.service.UserService;
import com.recovery.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Result getUserInfo(String userID) {
        return null;
    }

    @Override
    public Result alterUserInfo(UserInfoDto userInfoDto) {
        return null;
    }
}
