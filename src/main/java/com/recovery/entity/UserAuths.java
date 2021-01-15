package com.recovery.entity;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


//用户登录表
@Entity
@Data
public class UserAuths {
    //用户ID：主键，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer userID;

    //手机号：可用手机号代替id登陆
    @Column(nullable = false, length = 20)
    private String phone;

    //登陆密码
    @Column(nullable = false, length = 200)
    private String password;

    //用户状态：0-正常，1-冻结
    @Column(nullable = false, length = 11)
    private Integer status = 0;

    //登录次数：累计登录次数
    @Column(nullable = false, length = 11)
    private Integer loginCount = 0;

    //最后一次登入时间：@Modified
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column
    private Date lastLoginDateTime;
}
