package com.recovery.entity;

import lombok.Data;

import javax.persistence.*;

//首页图片
@Entity
@Data
public class ImageStore {
    //图片序号:主键，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer imageID;

    //图片url
    @Column(nullable = false, length = 200)
    private String imageUrl;
}
