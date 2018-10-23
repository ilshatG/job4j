package ru.job4j.list;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SimpleStackTest {
    SimpleStack<Integer> stack;
    @Before
    public void init() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void sequentialCheckingValues() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void ifPollFromEmptySteckGetNoSuchElementException() {
        for (int i = 0; i < 4; i++) {
            stack.poll();
        }
    }
}