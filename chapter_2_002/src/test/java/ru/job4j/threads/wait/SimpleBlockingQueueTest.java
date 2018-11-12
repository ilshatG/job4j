package ru.job4j.threads.wait;
import org.junit.Test;

import static java.lang.System.exit;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    @Test
    public void whenProduceThenonsume() throws InterruptedException {
        SimpleBlockingQueue queue = new SimpleBlockingQueue();
        Thread produce = new Thread(new Producer(queue));
        Thread consume = new Thread(new Consumer(queue));
        produce.start();
        consume.start();
    }
}
