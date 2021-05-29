package com.example.threadpooltaskexecutor;

import com.example.threadpooltaskexecutor.runnable.TestThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@Slf4j
public class ThreadPoolTaskExecutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadPoolTaskExecutorApplication.class, args);

//        threadPoolTaskTest();
    }


    private static void threadPoolTaskTest() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("my-test-");

        // thread 기본 수. task가 오면 1차로 배정된다.
        executor.setCorePoolSize(1);

        // thread 대기 queue 너비. 기본 thread pool이 가득차면 해당 큐에 task가 쌓인다.
        executor.setQueueCapacity(5);

        // thread 최대 확장 가능 수. queue가 가득 찬 후 새로운 쓰레드가 생성될 수 있는 최대 thread pool size값
        // => queue가 꽉 차야 새로 생성하는것이 확실한데.. 왜 이딴식으로 만들어져있는건지 이유를 모르겠다.
        executor.setMaxPoolSize(3);

        // 일이 배정될때.. corePoolSize + queueCapacity + (maxPoolSize - corePoolSize) 이상의 값은 저장할 곳이 없기에 TaskRejectedException 후 버려진다.

        /*
        * 결론
        * thread를 배정받아 시작하는 task가 들어올 시..
        * 1차로 기본 생성 후 대기중인 corePoolSize에 적재된다.
        * 2차로 corePoolSize에 적재 후 남은 task는 queueCapacity 만큼 queue에 적재된다.
        * 3차로 queue에 쌓고도 넘치는 task는 maxPoolSize만큼 thread가 동적으로 늘어나며 적제된다. 이후로도 남은 task는 rejected된다.
        *
        * !주의 : 3차에서 thread가 늘어날때 queue에서 선입선출로 빠지는것인지 아니고, 나머지 thread가 분배되는것이다. (하긴 async인데 순서가 중요하나 싶긴 하다)
        * */

        executor.initialize();

        log.info("executing threads...");

//        Runnable r = () -> {
//            try{
//                log.info(Thread.currentThread().getName());
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };

        // task가 10개일 경우 기본 1개 thread에 task 분배 후, queue에 5개의 task 적제, 이후 2개의 추가 thread 생성(max pool size). 남은 2개의 task 버려짐.
        // task가 6개 이하일 경우 queue에 1개 이상의 task가 쌓이고 1개의 thread로 나머지 queue task를 실행시킴.
        // task가 7~8개일 경우 queue에 쌓고도 초과하는 task만큼 thread가 추가 생성됨. 이후 queue에 있는 task를 생성된 thread들로 처리함.
        for (int i = 0; i < 8; i++) {
            TestThread r = new TestThread(i);

            executor.execute(r);

            System.out.print("poolSize : " + executor.getPoolSize());
            System.out.print(", active : " + executor.getActiveCount());
            System.out.println(", queue : " + executor.getThreadPoolExecutor().getQueue().size());
        }
    }

}
