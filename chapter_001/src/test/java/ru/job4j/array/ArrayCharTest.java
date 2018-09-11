package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    @Test
    public void whenStartWithLongerPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Mother");
        boolean result = word.startWith("Motherfucker");
        assertThat(result, is(true));
    }

    @Test
    public void whenEmptyPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Motherfucker");
        boolean result = word.startWith("");
        assertThat(result, is(true));
    }

    @Test
    public void whenEmptyStringThenTrue() {
        ArrayChar word = new ArrayChar("");
        boolean result = word.startWith("Motherfucker");
        assertThat(result, is(true));
    }

    @Test
    public void allEmptyThenTrue() {
        ArrayChar word = new ArrayChar("");
        boolean result = word.startWith("");
        assertThat(result, is(true));
    }

}