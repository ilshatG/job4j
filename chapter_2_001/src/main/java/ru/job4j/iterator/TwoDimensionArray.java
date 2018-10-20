package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TwoDimensionArray implements Iterator {
    private int[][] values;
    private int row = 0;
    private int columnIndex = 0;

    public TwoDimensionArray(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return row < values.length && columnIndex < values[row].length;
    }

    @Override
    public Object next() {
        int result = 0;
        if (row < values.length && columnIndex < values[row].length) {
            result = values[row][columnIndex];
            if (columnIndex >= values[row].length - 1) {
                columnIndex = 0;
                row++;
            } else {
                columnIndex++;
            }
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
