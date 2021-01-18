package com.recovery.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class UserInfoAlterDto {
    private String userID;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private Integer sex = 0;
    private Float height;
    private Float weight;
    private String phoneNum;
}
