package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] testArray = {"one", "two", "three", "one"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(testArray);
        String[] expect = {"one", "two", "three"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRemoveDuplicatesFromUniqueArrayThenSameArray() {
        String[] testArray = {"one", "two", "three"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(testArray);
        String[] expect = {"one", "two", "three"};
        assertThat(result, is(expect));
    }

    @Test
    public void crashTestWhenRemoveDuplicatesFromArrayOfOneValueThenSameArray() {
        String[] testArray = {"three"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(testArray);
        String[] expect = {"three"};
        assertThat(result, is(expect));
    }
}