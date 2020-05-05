package com.zjubiomedit.autotask;

import com.zjubiomedit.service.impl.AutoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@Component
@Slf4j
@RestController
public class AutoTask {

    @Autowired
    AutoServiceImpl autoService;

    @Async
    @Scheduled(cron = "0 0 0 ? * 1")
//    @Scheduled(cron = "*/5 * * * * ?") //test
    public void generateWeeklyAlert() {
        log.info("generateWeeklyAlert");
        autoService.autoGenerateWeeklyAlert();
    }

    @Async
    @Scheduled(cron = "0 15 0 * * ?")
//    @Scheduled(cron = "*/5 * * * * ?") //test
    public void generateDailyAlert() {
        log.info("generateDailyAlert");
        autoService.autoGenerateDailyAlert();
    }

    @Async
    @Scheduled(cron = "0 30 0 */14 * ?")
//    @Scheduled(cron = "*/5 * * * * ?") //test
    public void generateEvaluationRecord() {
        log.info("generateEvaluation");
        autoService.autoGenerateEvaluation();
    }

//    @Async
//    @Scheduled(cron = "0 45 0 * * 1")
//        public void generateComplianceRate() {
//        //需要确定医嘱次数
//        autoService.autoGenerateCompliance();
//    }
//
//    @Async
//    @Scheduled(cron = "0 0 1 * * 1")
//    public void generateManagePlan() {
//        //详细计划未定
//        autoService.autoGenerateManagePlan();
//    }

    // 测试用-----------------------------------------------------------------
//    // 自动插入测试用医生患者账号和各种记录
//    @Async
//    @Scheduled(cron = "*/1 * * * * ?")
//    public void insertUserAndRecord() {
//        autoService.autoInsertDocUser(autoService.getDocCount());
//        autoService.autoInsertPatUser(autoService.getPatCount());
//        autoService.autoInsertRecord(autoService.getPatCount() - 1);
//    }
//    // 需要自动审核患者注册时使用，测试完审核页面后
//    @Async
//    @Scheduled(cron = "*/10 * * * * ?")
//    public void autoReview(){
//        log.info("autoReviewRegisterAndReferral");
//        autoService.autoReviewRegister();
//    }

}
