package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class mergeSortedArraysTest {
    @Test
    public void whenMergeArraysOfEqualSizesThenGetSortedArray() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] result = mergeSortedArrays.mergeArrays(array1, array2);
        int[] expect = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenMergeAnotherArraysOfEqualSizesThenGetSortedArray() {
        int[] array1 = {1, 3, 7, 14, 25};
        int[] array2 = {15, 20, 30, 40, 50};
        int[] result = mergeSortedArrays.mergeArrays(array1, array2);
        int[] expect = {1, 3, 7, 14, 15, 20, 25, 30, 40, 50};
        assertThat(result, is(expect));
    }

    @Test
    public void whenMergeArraysOfDifferentSizesThenGetSortedArray() {
        int[] array1 = {1, 3, 7, 14};
        int[] array2 = {15, 20, 30, 40, 50};
        int[] result = mergeSortedArrays.mergeArrays(array1, array2);
        int[] expect = {1, 3, 7, 14, 15, 20, 30, 40, 50};
        assertThat(result, is(expect));
    }
}