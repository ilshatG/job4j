package ru.job4j.tree;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
    Tree<Integer> tree = new Tree<>();
    Iterator<Node<Integer>> it;
    @Before
    public void init() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        it = tree.iterator();
    }

    @Test
    public void when6ElFindLastThen6() {
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void whenAddToUnExistingParentThenShouldntFind() {
        tree.add(8, 9);
        assertThat(
                tree.findBy(9).isPresent(),
                is(false)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next().getValue(), is(1));
        assertThat(it.next().getValue(), is(2));
        assertThat(it.next().getValue(), is(3));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
    }

}