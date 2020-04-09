package com.zjubiomedit.controller;

import com.zjubiomedit.dto.DoctorEndDto.DoctorCreatePatientDto;
import com.zjubiomedit.entity.User.DoctorUserAuths;
import com.zjubiomedit.service.impl.UserServiceImpl;
import com.zjubiomedit.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "【综合】用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "【后台】新建医生账号")
    @PostMapping(value = "/doctor/create")
    public Result doctorUserSignUp(@RequestBody DoctorUserAuths doctorUserAuths){
        return userService.createDoctorUser(doctorUserAuths);
    }

    @ApiOperation(value = "【医生】新建患者账号")
    @PostMapping(value = "/patient/create")
    public Result patientUserSignUp(@RequestBody DoctorCreatePatientDto doctorCreatePatientDto) {
        return userService.createPatientUser(doctorCreatePatientDto);
    }


    @ApiOperation(value = "获取患者基本信息", response = Result.class)
    @GetMapping(value = "/patient/detail/baseinfo")
    public Result patientBaseInfo(@RequestParam(value = "patientID") Long patientID){
        //个人基本信息
        return userService.getPatientBaseInfo(patientID);
    }

    @ApiOperation(value = "获取患者管理信息", response = Result.class)
    @GetMapping(value = "/patient/detail/manage")
    public Result patientManageDetail(@RequestParam(value = "patientID") Long patientID){
        //管理信息
        return userService.getPatientManageDetail(patientID);
    }

    @ApiOperation(value = "获取患者当前转诊信息", response = Result.class)
    @GetMapping(value = "/patient/detail/referral")
    public Result patientReferralDetail(@RequestParam(value = "patientID") Long patientID){
        //转诊信息
        return userService.getPatientReferralDetail(patientID);
    }

    @ApiOperation(value = "【医院】获取本院医生列表", response = Result.class)
    @GetMapping(value = "/doctor/list")
    public Result doctorSelectList(@RequestParam(value = "hospitalID") Long hospitalID){
        return userService.getDoctorList(hospitalID);
    }

    @ApiOperation(value = "获取医生/医院账户ID对应姓名", response = Result.class)
    @GetMapping(value = "/doctor/name")
    public Result doctorNameByID(@RequestParam(value = "doctorID") Long doctorID){
        return userService.getDoctorNameByDoctorID(doctorID);
    }

    @ApiOperation(value = "获取患者管理计划历史列表", response = Result.class)
    @GetMapping(value = "/patient/history/plan")
    public Result patientManagePlanDetail(@RequestParam(value = "patientID") Long patientID){
        //管理计划
        return userService.getPatientManagePlanDetail(patientID);
    }

    @ApiOperation(value = "获取患者预警历史(分页)", response = Result.class)
    @GetMapping(value = "/patient/history/alert/page")
    public Result patientAlertDetail(@RequestParam(value = "patientID") Long patientID,
                                     @RequestParam(value = "pageIndex") Integer pageIndex,
                                     @RequestParam(value = "pageOffset") Integer pageOffset){
        //预警历史
        return userService.getPatientAlertDetail(patientID, pageIndex, pageOffset);
    }

    @ApiOperation(value = "获取患者随访历史记录(分页)", response = Result.class)
    @GetMapping(value = "/patient/history/followup/page")
    public Result patientFollowupDetail(@RequestParam(value = "patientID") Long patientID,
                                     @RequestParam(value = "pageIndex") Integer pageIndex,
                                     @RequestParam(value = "pageOffset") Integer pageOffset){
        //预警历史
        return userService.getPatientFollowupDetail(patientID, pageIndex, pageOffset);
    }



}
