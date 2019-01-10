package ru.job4j.threads.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.exit;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    final private int LIMIT = 10;

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public synchronized void offer(T value) {
        boolean result = false;
        while (this.queue.size() >= LIMIT) {
            try {
                System.out.println("offer wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.queue.size() > 0) {
            notify();
        }
        queue.offer(value);
        System.out.println("offer: " + value);
        notify();
    }

    public synchronized T poll() {
        while (this.queue.size() == 0) {
            try {
                System.out.println("wait poll");
                wait();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("breaking");
                Thread.currentThread().interrupt();
                //exit(0);
            }
        }
        if (queue.size() < LIMIT ) {
            notify();
        }
        T result = queue.poll();
        System.out.println("poll: " + result);
        return result;
    }

    public synchronized int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        SimpleBlockingQueue queue = new SimpleBlockingQueue();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class Consumer implements Runnable {
    SimpleBlockingQueue queue;
    public Consumer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true) {
            this.queue.poll();
        }
    }
}

class Producer implements Runnable {
    SimpleBlockingQueue queue;
    public Producer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true) {
            this.queue.offer(Math.round(Math.random() * 100));
        }
    }
}