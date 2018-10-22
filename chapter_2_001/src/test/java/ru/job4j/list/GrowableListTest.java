package ru.job4j.list;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterator.TwoDimensionArray;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GrowableListTest {
    GrowableList<Integer> list = new GrowableList<>();
    Iterator<Integer> it;

    @Before
    public void init() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        it = list.iterator();
    }

    @Test
    public void whenAddSixGetCorrectListOfValues() {
       list.add(6);
       List<Integer> result = new ArrayList<>();
       for (int i = 0; i < 6; i++) {
           result.add(list.get(i));
       }
       assertThat(result, is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void whenAddSevenGetRealArraySize12() {
        list.add(6);
        list.add(7);
        assertThat(list.getRealSize(), is(9));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }
    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        for (int i = 0; i <= list.getRealSize(); i++) {
            it.next();
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        list.add(6);
        it.next();
    }
}