package com.recovery.entity;

import lombok.Data;

import javax.persistence.*;

//示例视频表
@Entity
@Data
public class VideoStore {
    //视频序号:主键，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer videoID;

    //视频Url
    @Column(nullable = false, length = 200)
    private String videoUrl;
}
