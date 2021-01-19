package com.recovery.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long serialNo;

    @Column(nullable = false, length = 50)
    private String userID;

    // 训练方案序号: 0-颈椎病疼痛训练计划 1-颈部痉挛锻炼方案 2-颈部拉伤锻炼方案 3-颈部慢性疼痛缓解训练计划
    @Column(nullable = false)
    private Integer planID;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @LastModifiedDate
    private Date createdDate;

    // 从0开始编码
    @Column(nullable = false)
    private Integer actionNum = 0;

    // 整数百分比
    @Column(nullable = false)
    private Integer actionSec = 0;
}
