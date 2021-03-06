package com.example.threadpooltaskexecutor.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WithAsyncTest {

    @Autowired
    private WithAsync withAsync;

    @Test
    public void asyncTest() throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            withAsync.task();

        }
        //ThreadPoolTaskExecutor 는 demon thread로 추정된다. main thread를 살려주어야 에러가 나지 않는다.
        Thread.sleep(1000000000);
    }
}