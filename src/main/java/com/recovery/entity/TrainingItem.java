package com.recovery.entity;

import lombok.Data;

import javax.persistence.*;

//训练方案（项目）表
@Entity
@Data
public class TrainingItem {
    //方案序号：主键，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer trainingItemID;
    //方案内容
    @Column(length = 50)
    private String trainingItemContent;
}
