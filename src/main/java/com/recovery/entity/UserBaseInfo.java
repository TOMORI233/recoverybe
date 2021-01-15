package com.recovery.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//用户基本信息表
@Entity
@Data
public class UserBaseInfo {
    //序号：主键，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer serialNo;
    //用户ID
    @Column(nullable = false, length = 11)
    private Integer userID;
    //姓名
    @Column(nullable = false, length = 20)
    private String name;
    //性别：0-未知，1-男，2-女
    @Column(nullable = false, length = 11)
    private Integer sex = 0;
    //出生日期
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateOfBirth;
    //身高：单位：cm
    @Column(length = 11)
    private Integer height;
    //体重：单位：kg
    @Column
    private Float weight;
}
