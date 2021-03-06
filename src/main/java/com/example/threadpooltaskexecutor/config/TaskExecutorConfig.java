package com.example.threadpooltaskexecutor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class TaskExecutorConfig {

    @Bean
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("my-test1-");
        executor.setCorePoolSize(1);
        executor.setQueueCapacity(5);
        executor.setMaxPoolSize(3);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    @Bean
    public ThreadPoolTaskExecutor executor2(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("my-test2-");
        executor.setCorePoolSize(1);
        executor.setQueueCapacity(5);
        executor.setMaxPoolSize(3);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}
