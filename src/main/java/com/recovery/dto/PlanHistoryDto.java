package com.recovery.dto;

import com.recovery.util.Utils;
import lombok.Data;

@Data
public class PlanHistoryDto {
    private Long serialNo;
    private Integer newUser = Utils.USER_OLD;
    private String userID;
    private Integer planID;
    private Integer actionNum = 0;
    private Integer actionSec = 0;
}
