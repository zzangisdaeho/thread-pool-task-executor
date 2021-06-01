package com.example.threadpooltaskexecutor.service;

import com.example.threadpooltaskexecutor.runnable.TestThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WithAutowired {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    public void executeThreads() {
        log.info("executing threads....");
//        Runnable r = () -> {
//            try {
//                log.info(Thread.currentThread().getName() + ", Now sleeping 3 seconds...");
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };

        for (int i = 0; i < 8; i++) {
            TestThread r = new TestThread(i);
            executor.execute(r);
        }
    }
}
