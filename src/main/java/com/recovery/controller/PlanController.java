package com.recovery.controller;

import com.recovery.dto.NewPlanDto;
import com.recovery.service.impl.PlanServiceImpl;
import com.recovery.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = "训练计划/方案管理")
@RestController
@CrossOrigin
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    PlanServiceImpl planService;

    @ApiOperation(value = "新建方案")
    @PostMapping("/new")
    public Result createNewPlan(@RequestBody NewPlanDto newPlanDto) {
        return planService.createNewPlan(newPlanDto);
    }

    @ApiOperation(value = "查询指定日期方案")
    @GetMapping("/history")
    public Result getPlanHistByDate(@RequestParam(value = "userID") String userID,
                              @RequestParam(value = "date") Date date) {
        return planService.getPlanHistByDate(userID, date);
    }

    @ApiOperation(value = "更新方案进度")
    @PutMapping("/process")
    public Result updatePlanProcess(@RequestParam(value = "serialNo") Long serialNo,
                                    @RequestParam(value = "actionNum") Integer actionNum,
                                    @RequestParam(value = "actionPercent") Integer actionPercent) {
        return planService.updatePlanProcess(serialNo, actionNum, actionPercent);
    }
}
