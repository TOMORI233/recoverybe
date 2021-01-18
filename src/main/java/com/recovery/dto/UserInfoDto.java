package com.recovery.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private String userID;
    private Integer age;
    private Integer sex = 0;
    private Float height;
    private Float weight;
    private String phoneNum;
}
