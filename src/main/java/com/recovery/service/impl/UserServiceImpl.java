package com.recovery.service.impl;

import com.recovery.dao.UserInfoRepository;
import com.recovery.dto.UserInfoAlterDto;
import com.recovery.dto.UserInfoDto;
import com.recovery.entity.UserInfo;
import com.recovery.service.UserService;
import com.recovery.util.Result;
import com.recovery.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public Result getUserInfo(String userID) {
        UserInfoDto userInfoDto = new UserInfoDto();
        Optional<UserInfo> userInfoOptional = userInfoRepository.findByUserID(userID);
        userInfoOptional.ifPresent(userInfo -> {
            BeanUtils.copyProperties(userInfo, userInfoDto);
            Integer age = null;
            if (userInfo.getDateOfBirth() != null) {
                try {
                    age = Utils.getAgeByBirth(userInfo.getDateOfBirth());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            userInfoDto.setAge(age);
        });
        return new Result(userInfoDto);
    }

    @Override
    public Result alterUserInfo(UserInfoAlterDto userInfoAlterDto) {
        Optional<UserInfo> thisUserOptional = userInfoRepository.findByUserID(userInfoAlterDto.getUserID());
        thisUserOptional.ifPresent(thisUser -> {
            BeanUtils.copyProperties(userInfoAlterDto, thisUser);
            userInfoRepository.save(thisUser);
        });
        return new Result();
    }

    @Override
    public Result createUser(String userID, Integer sex) {
        UserInfo newUser = new UserInfo();
        newUser.setUserID(userID);
        newUser.setSex(sex);
        userInfoRepository.save(newUser);
        return new Result();
    }
}
