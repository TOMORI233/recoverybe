package com.recovery.service;

import com.recovery.dto.UserInfoDto;
import com.recovery.util.Result;

public interface UserService {
    Result getUserInfo(String userID);

    Result alterUserInfo(UserInfoDto userInfoDto);
}
