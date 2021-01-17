package com.recovery.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDto {
    // UserAuths
    private Long userID;
    private Integer loginCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginDateTime;
    // UserBaseInfo
    private String name;
    private Integer sex;
    private Float height;
    private Float weight;
    private Integer age;
}
