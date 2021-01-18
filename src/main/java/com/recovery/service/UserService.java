package com.recovery.service;

import com.recovery.dto.UserInfoAlterDto;
import com.recovery.util.Result;

public interface UserService {
    Result getUserInfo(String userID);

    Result alterUserInfo(UserInfoAlterDto userInfoAlterDto);

    Result createUser(String userID, Integer sex);
}
