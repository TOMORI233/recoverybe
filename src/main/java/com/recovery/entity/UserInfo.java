package com.recovery.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long serialNo;

    @Column(nullable = false, length = 50)
    private String userID;

    @Column(length = 20)
    private String phoneNum;

    //性别：0-未知，1-男，2-女
    @Column(nullable = false)
    private Integer sex = 0;

    //出生日期
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    //身高：单位：cm
    private Float height;

    //体重：单位：kg
    private Float weight;
}
