package com.recovery.service;

import com.recovery.dto.NewPlanDto;
import com.recovery.util.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

public interface PlanService {
    Result createNewPlan(NewPlanDto newPlanDto);

    Result getPlanToday(String userID);

    Result getPlanHistByDate(String userID, Date date);

    Result updatePlanProcess(Long serialNo, Integer actionNum, Integer actionSec);
}
