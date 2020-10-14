package com.recovery.autotask;

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

    @Async
    @Scheduled(cron = "0 0 0 ? * 1")
//    @Scheduled(cron = "*/5 * * * * ?") //test
    public void generateGreetings() {
        log.info("hello");
    }

}
