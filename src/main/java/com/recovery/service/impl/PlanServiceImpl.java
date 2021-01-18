package com.recovery.service.impl;

import com.recovery.dto.NewPlanDto;
import com.recovery.service.PlanService;
import com.recovery.util.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public Result createNewPlan(NewPlanDto newPlanDto) {
        return null;
    }

    @Override
    public Result getPlanHistByDate(String userID, Date date) {
        return null;
    }

    @Override
    public Result updatePlanProcess(String userID, Integer actionNum, Integer actionPercent) {
        return null;
    }
}
