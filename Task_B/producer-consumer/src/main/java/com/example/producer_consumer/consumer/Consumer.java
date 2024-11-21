package com.example.producerconsumer.consumer;

import com.example.producerconsumer.model.Task;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;

@Component
public class Consumer implements Runnable {

    private final BlockingQueue<Task> taskQueue;
    private volatile boolean running = true;

    public Consumer(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        try {
            while (running) {
                Task task = taskQueue.take(); // Blocks if the queue is empty
                System.out.println("Consumed: " + task);
                Thread.sleep(200); // Simulate processing time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer interrupted.");
        }
    }
}
