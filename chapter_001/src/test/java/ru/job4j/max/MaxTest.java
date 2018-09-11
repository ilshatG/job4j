package ru.job4j.max;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstGreaerSecond() {
        Max maxim = new Max();
        int result = maxim.max(6, 2);
        assertThat(result, is(6));
    }

    @Test
    public void whenFirstEqualsSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 2);
        assertThat(result, is(2));
    }


    @Test
    public void whenThirdGraterThanFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstGraterThanThirdAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(7, 3, 4);
        assertThat(result, is(7));
    }

    @Test
    public void whenFirstEqualsThirdAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(8, 8, 8);
        assertThat(result, is(8));
    }

}