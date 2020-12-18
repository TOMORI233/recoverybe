package com.recovery.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    @Column(nullable = false, length = 50)
    private String userName;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false)
    private String password;
}
