package com.example.producerconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
public class TaskQueueConfig {

    @Bean
    public BlockingQueue<Task> taskQueue() {
        return new LinkedBlockingQueue<>(10); // Max capacity of 10 tasks
    }
}
