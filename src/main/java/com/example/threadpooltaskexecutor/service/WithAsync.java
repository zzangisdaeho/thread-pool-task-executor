package com.example.threadpooltaskexecutor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WithAsync {

    @Async
    public void task() {
        try {
            log.info(Thread.currentThread().getName() + ", Now sleeping 3 seconds...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
