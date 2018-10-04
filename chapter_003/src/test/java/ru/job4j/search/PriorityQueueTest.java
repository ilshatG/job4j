package ru.job4j.search;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("ultra", 0));
        Task result = queue.take();
        assertThat(result.getDesc(), is("ultra"));
    }

    @Test
    public void whenAddLowerPrioritySizeIs5() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("ultra", 0));
        queue.put(new Task("optional", 8));
        LinkedList<Task> result = queue.getList();
        assertThat(result.size(), is(5));
    }

    @Test
    public void whenAddLowerPriorityIsOptionalIs() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("ultra", 0));
        queue.put(new Task("optional", 8));

        String[] result = new String[queue.getList().size()];
        int index = 0;
        while (!queue.getList().isEmpty()) {
            result[index++] = queue.take().getDesc();
        }

        assertThat(result, is(new String[]{"ultra", "urgent", "middle", "low", "optional"}));
    }
}