package com.example.threadpooltaskexecutor.runnable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class TestThread implements Runnable {

    private int number;

    @Override
    public void run() {
        try {
            log.info(Thread.currentThread().getName() + " : task number : " + number);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
