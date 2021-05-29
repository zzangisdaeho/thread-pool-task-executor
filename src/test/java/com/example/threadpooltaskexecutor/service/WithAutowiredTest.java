package com.example.threadpooltaskexecutor.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WithAutowiredTest {

    @Autowired
    private WithAutowired withAutowired;

    @Test
    public void testExecuteThreads() throws InterruptedException {
        withAutowired.executeThreads();

        //ThreadPoolTaskExecutor 는 demon thread로 추정된다. main thread를 살려주어야 에러가 나지 않는다.
        Thread.sleep(1000000000);
    }
}