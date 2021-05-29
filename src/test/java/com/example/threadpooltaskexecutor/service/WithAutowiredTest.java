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

        Thread.sleep(1000000000);
    }
}