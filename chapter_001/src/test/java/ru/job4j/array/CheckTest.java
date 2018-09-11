package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CheckTest {
    @Test
    public void whenArrayHas5TruesThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true, true, true};
        boolean result = check.mono(input);
        boolean expect = true;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas5FalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, false};
        boolean result = check.mono(input);
        boolean expect = true;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas4FalseAnd1TrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, true, false, false, false};
        boolean result = check.mono(input);
        boolean expect = false;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas3TruesAnd1FalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true, false};
        boolean result = check.mono(input);
        boolean expect = false;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas1TrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true};
        boolean result = check.mono(input);
        boolean expect = true;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas1FalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false};
        boolean result = check.mono(input);
        boolean expect = true;
        assertThat(result, is(expect));
    }


}