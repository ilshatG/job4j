package ru.job4j.set;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    SimpleSet<Integer> set = new SimpleSet<>();
    Iterator<Integer> it;

    @Test
    public void whenAddDoublesReturnFalse() {
        assertThat(set.add(1), is(true));
        assertThat(set.add(2), is(true));
        assertThat(set.add(3), is(true));
        assertThat(set.add(3), is(false));
    }

    @Test
    public void sequentialAppropriateValues() {
        set.add(1);
        set.add(2);
        set.add(3);
        it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

}