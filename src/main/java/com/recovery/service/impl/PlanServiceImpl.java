package com.recovery.service.impl;

import com.recovery.dao.TrainingPlanRepository;
import com.recovery.dto.NewPlanDto;
import com.recovery.dto.PlanHistoryDto;
import com.recovery.dto.PlanTodayDto;
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
import java.util.List;
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
            existedPlan.setActionSec(0);
            trainingPlanRepository.save(existedPlan);
        } else {
            trainingPlanRepository.save(newPlan);
        }
        return new Result();
    }

    @Override
    public Result getPlanToday(String userID) throws ParseException {
        PlanTodayDto planTodayDto = new PlanTodayDto();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        String strToday = sm.format(new Date());
        List<TrainingPlan> trainingPlanOptional = trainingPlanRepository.findByUserIDOrderByCreatedDateDesc(userID);
        if(!trainingPlanOptional.isEmpty()){
                TrainingPlan trainingPlan = trainingPlanOptional.get(0);
                if(sm.format(trainingPlan.getCreatedDate()).equals(strToday)){
                    BeanUtils.copyProperties(trainingPlan, planTodayDto);
                }else {
                    TrainingPlan newTrainingPlan = new TrainingPlan();
                    newTrainingPlan.setCreatedDate(new Date());
                    newTrainingPlan.setActionNum(0);
                    newTrainingPlan.setActionSec(0);
                    newTrainingPlan.setUserID(trainingPlan.getUserID());
                    newTrainingPlan.setPlanID(trainingPlan.getPlanID());
                    trainingPlanRepository.save(newTrainingPlan);
                    Date today = sm.parse(strToday);
                    BeanUtils.copyProperties(trainingPlanRepository.findByUserIDAndCreatedDate(userID, today).get(), planTodayDto);

                }

        } else {
            planTodayDto.setNewUser(Utils.USER_NEW);
        }
        return new Result(planTodayDto);
    }

    @Override
    public Result getPlanHistByDate(String userID, Date date) {
        PlanHistoryDto planHistoryDto = new PlanHistoryDto();
        Optional<TrainingPlan> trainingPlanOptional = trainingPlanRepository.findByUserIDAndCreatedDate(userID, date);
        if(trainingPlanOptional.isPresent()){
            TrainingPlan trainingPlan = trainingPlanOptional.get();
            BeanUtils.copyProperties(trainingPlan, planHistoryDto);
        }
        return new Result(planHistoryDto);
    }


    @Override
    public Result updatePlanProcess(Long serialNo, Integer actionNum, Integer actionSec) {
        Optional<TrainingPlan> trainingPlanOptional = trainingPlanRepository.findBySerialNo(serialNo);
        trainingPlanOptional.ifPresent(trainingPlan -> {
            trainingPlan.setActionNum(actionNum);
            trainingPlan.setActionSec(actionSec);
            trainingPlanRepository.save(trainingPlan);
        });
        return new Result();
    }

}
