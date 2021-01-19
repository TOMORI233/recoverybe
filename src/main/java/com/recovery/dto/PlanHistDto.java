package com.recovery.dto;

import com.recovery.util.Utils;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class PlanHistDto {
    private Long serialNo;
    private Integer newUser = Utils.USER_OLD;
    private String userID;
    private Integer planID;
    private Integer actionNum = 0;
    private Integer actionSec = 0;
}
