package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    SimpleArray<Integer> sa = new SimpleArray<>(5);
    Iterator<Integer> it;


    @Before
    public void init() {
        sa.add(1);
        sa.add(2);
        sa.add(3);
        it = sa.iterator();
    }

    @Test
    public void whenAdd1valueGet5values() {
        sa.add(4);
        assertThat(sa.toList(), is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void whenSetFirstItemTo5ThenGet5() {
        sa.set(0, 5);
        assertThat(sa.get(0), is(5));
    }

    @Test
    public void whenDeleteThirdGet4values() {
        sa.add(4);
        sa.add(5);
        sa.delete(3);
        assertThat(sa.toList(), is(Arrays.asList(1, 2, 3, 5)));
    }

    @Test
    public void hasNextNextSequentialInvocation() {

        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        it.next();
    }

}