package com.recovery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

//训练记录表
@Entity
@Data
public class TrainingRecord {
    //序号：主键，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Long serialNo;

    //训练计划
    @Column(nullable = false, length = 11)
    private Long planID;

    //今日已完成时长：单位 min
    @Column(nullable = false)
    private Float trainedTime;

    //完成情况：0-未开始，1-正在进行方案一，2-正在进行方案二，以此类推
    @Column(nullable = false, length = 11)
    private Integer status = 0;

    //记录时间：@Create
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreatedDate
    @Column(nullable = false)
    private Date recordDateTime;
}
