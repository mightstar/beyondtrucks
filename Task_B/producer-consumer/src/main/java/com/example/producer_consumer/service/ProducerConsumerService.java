package com.example.producerconsumer.service;

import com.example.producerconsumer.consumer.Consumer;
import com.example.producerconsumer.producer.Producer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProducerConsumerService {

    private final BlockingQueue<Task> taskQueue;
    private final Producer producer;
    private final Consumer consumer;
    private final ExecutorService executorService;

    public ProducerConsumerService(BlockingQueue<Task> taskQueue, Producer producer, Consumer consumer) {
        this.taskQueue = taskQueue;
        this.producer = producer;
        this.consumer = consumer;
        this.executorService = Executors.newFixedThreadPool(2); // Two threads for producer and consumer
    }

    @PostConstruct
    public void start() {
        executorService.submit(producer);
        executorService.submit(consumer);
    }

    @PreDestroy
    public void stop() {
        producer.stop();
        consumer.stop();
        executorService.shutdownNow();
    }
}
