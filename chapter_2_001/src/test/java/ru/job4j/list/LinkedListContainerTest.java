package ru.job4j.list;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedListContainerTest {

    private LinkedListContainer<Integer> list;
    private Iterator<Integer> it;

    @Before
    public void beforeTest() {
        list = new LinkedListContainer<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        it = list.iterator();
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(5));
    }

    @Test
    public void whenAddFoutThenUseGetSequential() {
        list.add(6);
        assertThat(list.get(0), is(6));
        assertThat(list.get(1), is(5));
        assertThat(list.get(2), is(4));
        assertThat(list.get(3), is(3));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        MatcherAssert.assertThat(it.next(), is(5));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.next(), is(2));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(5));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.next(), is(2));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(5));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(4));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(false));
    }
    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        for (int i = 0; i <= 6; i++) {
            it.next();
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        list.add(6);
        it.next();
    }
}