package com.example.threadpooltaskexecutor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ThreadPoolTaskExecutorApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void printBeans(){

        // 등록된 bean의 이름을 get
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        // bean 이름을 출력
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}
