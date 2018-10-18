package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TwoDimensionArray implements Iterator {
    private int[][] values;
    private int index = 0;

    public TwoDimensionArray(int[][] values) {
        this.values = values;
    }

    private int arrayLength() {
        int length = 0;
        for (int[] array : values) {
            length += array.length;
        }
        return length;
    }

    int getItem(int i) {
        int counter = 0;
        boolean found = false;
        int result = 0;
        for (int[] array : values) {
            for (int value : array) {
                if (counter == i) {
                    result = value;
                    found = true;
                    break;
                } else {
                    counter++;
                }
            }
            if (found) {
                break;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return index < arrayLength();
    }

    @Override
    public Object next() {
        if (index >= arrayLength()) {
            throw new NoSuchElementException();
        }
        return getItem(index++);
    }
}
