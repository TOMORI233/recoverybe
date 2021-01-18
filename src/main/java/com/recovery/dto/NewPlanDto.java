package com.recovery.dto;

import lombok.Data;

@Data
public class NewPlanDto {
    private String userID;
    private Integer age;
    private Integer intensity;
    private Integer site;
    private Integer stage;
}
