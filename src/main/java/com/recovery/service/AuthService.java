package com.recovery.service;

import com.recovery.util.Result;

public interface AuthService {
    Result login(String userToken);
}
