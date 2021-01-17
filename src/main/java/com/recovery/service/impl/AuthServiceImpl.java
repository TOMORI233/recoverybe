package com.recovery.service.impl;

import com.recovery.dao.UserAuthsRepository;
import com.recovery.dao.UserBaseInfoRepository;
import com.recovery.dto.HomeDto;
import com.recovery.dto.LoginDto;
import com.recovery.entity.UserAuths;
import com.recovery.entity.UserBaseInfo;
import com.recovery.service.AuthService;
import com.recovery.util.JWTUtils;
import com.recovery.util.Result;
import com.recovery.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserAuthsRepository userAuthsRepository;

    @Autowired
    UserBaseInfoRepository userBaseInfoRepository;

    @Override
    public Result login(String userToken) {
        // parse token
        LoginDto loginDto = JWTUtils.parseToken(userToken);
        // authentication
        Optional<UserAuths> userOptional = userAuthsRepository.findByPhoneAndPassword(loginDto.getPhone(), loginDto.getPassword());
        Result result = new Result();
        result.setMessage("Login failed");
        HomeDto homeDto = new HomeDto();
        userOptional.ifPresent(userAuths -> {
            Optional<UserBaseInfo> infoOptional = userBaseInfoRepository.findByUserID(userAuths.getUserID());
            infoOptional.ifPresent(userBaseInfo -> {
                // 获取返回的信息
                BeanUtils.copyProperties(userAuths, homeDto);
                BeanUtils.copyProperties(userBaseInfo, homeDto);
                try {
                    homeDto.setAge(Utils.getAgeByBirth(userBaseInfo.getDateOfBirth()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // 改变登录次数
                userAuths.setLoginCount(userAuths.getLoginCount() + 1);
                userAuthsRepository.save(userAuths);
                result.setMessage("Login success");
                result.setData(homeDto);
            });
        });
        return result;
    }
}
