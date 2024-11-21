package com.example.producerconsumer.producer;

import com.example.producerconsumer.model.Task;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Producer implements Runnable {

    private final BlockingQueue<Task> taskQueue;
    private static final AtomicInteger taskIdGenerator = new AtomicInteger(1);
    private volatile boolean running = true;

    public Producer(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        try {
            while (running) {
                int taskId = taskIdGenerator.getAndIncrement();
                Task task = new Task(taskId, "Task Description " + taskId);
                taskQueue.put(task); // Blocks if the queue is full
                System.out.println("Produced: " + task);
                Thread.sleep(100); // Simulate production time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted.");
        }
    }
}
