package com.example.threadpooltaskexecutor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WithAsync {

    //taskexecutor가 2개 이상 등록되어 있는 경우, bean지정해주지 않으면 simpletask로 지정되어 돌아간다.
    @Async("executor2")
//    @Async
    public void task() {
        try {
            log.info(Thread.currentThread().getName() + ", Now sleeping 3 seconds...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
