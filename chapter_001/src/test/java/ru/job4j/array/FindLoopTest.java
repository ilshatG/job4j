package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHasValue5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasNoSearchValue6Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {0, 11, 3, 44};
        int value = 6;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasSearchValue0Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {0};
        int value = 0;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

}

