package ru.job4j.threads.monitor;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ThreadSafeListTest {
    @Test
    public void sequentialWhenChangeAfterIteratorGetInitialIterator() {
        ThreadSafeList<Integer> array = new ThreadSafeList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> it = array.iterator();
        array.add(4);
        assertThat(it.next(), is(array.get(0)));
        assertThat(it.next(), is(array.get(1)));
        assertThat(it.next(), is(array.get(2)));
        assertThat(it.hasNext(), is(false));
    }
}