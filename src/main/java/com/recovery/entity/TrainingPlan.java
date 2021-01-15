package com.recovery.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

//训练计划表
@Entity
@Data
public class TrainingPlan {
    //序号：主键，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer serialNo;

    //用户ID
    @Column(nullable = false, length = 11)
    private Integer userID;

    //损伤类型：0-颈椎韧带损伤，1-颈部肌肉痉挛，2-神经根型颈椎病，3-颈型颈椎病，4-颈椎椎管狭窄症，5-神经外伤，6-慢性疼痛，7-其他
    @Column(nullable = false, length = 11)
    private Integer damageType = 0;

    //是否就医：0-否，1-是
    @Column(nullable = false, length = 11)
    private Integer hospitalizeStatus = 0;

    //疼痛时长：0-不到四周，1- 四到十二周，2-超过十二周
    @Column(nullable = false, length = 11)
    private Integer painTime;

    //训练强度：0-柔缓，1-中度，2-激烈
    @Column(nullable = false, length = 11)
    private Integer exIntensity = 0;

    //训练方案序号组：用逗号分隔，如：1,2,4
    @Column(nullable = false, length = 50)
    private String itemIDSet;

    //计划开始时间
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(nullable = false)
    private Date startDateTime;

    //计划结束时间
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(nullable = false)
    private Date endDateTime;

    //日计划时长：单位 min
    @Column(nullable = false)
    private Float dayDuration;

    //计划执行状态：0-未开始，1-进行中，2-已结束，3-已废止
    @Column(nullable = false, length = 11)
    private Integer status = 0;

    //计划制定时间：@Create
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false)
    private Date createDateTime;
}
