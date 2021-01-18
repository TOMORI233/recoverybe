package com.recovery.service.impl;

import com.recovery.dao.TrainingPlanRepository;
import com.recovery.dto.NewPlanDto;
import com.recovery.dto.PlanHistDto;
import com.recovery.entity.TrainingPlan;
import com.recovery.service.PlanService;
import com.recovery.util.Result;
import com.recovery.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class PlanServiceImpl implements PlanService {
    @Autowired
    TrainingPlanRepository trainingPlanRepository;

    @Override
    public Result createNewPlan(NewPlanDto newPlanDto) {
        TrainingPlan newPlan = new TrainingPlan();
        Integer site = newPlanDto.getSite();
        Integer planID = null;
        switch (site) {
            case 0:
            case 2:
            case 3:
            case 4:
                planID = 0;
                break;
            case 1:
                planID = 1;
                break;
            case 5:
                planID = 2;
                break;
            case 6:
                planID = 3;
                break;
            default:
                break;
        }
        BeanUtils.copyProperties(newPlanDto, newPlan);
        newPlan.setPlanID(planID);

        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        String strToday = sm.format(new Date());
        Date today = null;
        try {
            today = sm.parse(strToday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Optional<TrainingPlan> trainingPlanOptional = trainingPlanRepository.findByUserIDAndCreatedDateGreaterThanEqual(newPlanDto.getUserID(), today);
        if (trainingPlanOptional.isPresent()) {
            TrainingPlan existedPlan = trainingPlanOptional.get();
            existedPlan.setPlanID(planID);
            existedPlan.setActionNum(0);
            existedPlan.setActionPercent(0);
            trainingPlanRepository.save(existedPlan);
        } else {
            trainingPlanRepository.save(newPlan);
        }
        return new Result();
    }

    @Override
    public Result getPlanHistByDate(String userID, Date date) {
        PlanHistDto planHistDto = new PlanHistDto();
        Optional<TrainingPlan> trainingPlanOptional = trainingPlanRepository.findByUserIDAndCreatedDateGreaterThanEqual(userID, date);
        if(trainingPlanOptional.isPresent()){
            TrainingPlan trainingPlan = trainingPlanOptional.get();
            BeanUtils.copyProperties(trainingPlan, planHistDto);
        } else {
            planHistDto.setNewUser(Utils.USER_NEW);
        }
        return new Result(planHistDto);
    }

    @Override
    public Result updatePlanProcess(Long serialNo, Integer actionNum, Integer actionPercent) {
        Optional<TrainingPlan> trainingPlanOptional = trainingPlanRepository.findBySerialNo(serialNo);
        trainingPlanOptional.ifPresent(trainingPlan -> {
            trainingPlan.setActionNum(actionNum);
            trainingPlan.setActionPercent(actionPercent);
            trainingPlanRepository.save(trainingPlan);
        });
        return new Result();
    }

}
