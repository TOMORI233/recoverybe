package com.recovery.util;

import com.recovery.dto.LoginDto;

public class JWTUtils {
    public static LoginDto parseToken(String userToken) {
        String[] strlist = userToken.split(",");
        String phone = strlist[0];
        String password = strlist[1];
        LoginDto loginDto = new LoginDto(phone, password);
        return loginDto;
    }
}
