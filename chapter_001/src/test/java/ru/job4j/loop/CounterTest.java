package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ilshat Gaifutdinov(mailto:ilshatrashidovich@rambler.ru)
 * @version $Id$
 * @since 08.09.2018
 */
public class CounterTest {

    @Test
    public void whenAddEvenNumbersFromOneTwoTenThirty() {
        int[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Counter counter = new Counter( testArray );
        int result = counter.add(0,9);
        int expect = 30;
        assertThat(result, is(expect));
    }
}