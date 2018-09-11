package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] testArray = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testArray);
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortArrayWithTreeElementsThenSortedArray() {
        int[] testArray = {10, 5, 4};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testArray);
        int[] expected = {4, 5, 10};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortArrayWithOneElementsThenSortedArray() {
        int[] testArray = {10};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testArray);
        int[] expected = {10};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortArrayWithTwoElementsThenSortedArray() {
        int[] testArray = {1, 10};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testArray);
        int[] expected = {1, 10};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortArrayWithEmptyArray() {
        int[] testArray = {};
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testArray);
        int[] expected = {};
        assertThat(result, is(expected));
    }


}