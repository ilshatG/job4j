package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] values;
    private int index = 0;

    public SimpleArray(int size) {
        this.values = (T[]) new Object[size];
    }

    public void add(T model) {
        values[this.index++] = model;
    }

    public void set(int index, T model) {
        values[index] = model;
    }

    public void delete(int index) {
        if (this.index > 0 && index <= this.index) {
            System.arraycopy(values, index + 1, values, index, values.length - index - 1);
            values[values.length - 1] = null;
            this.index--;
        }
    }

    T get(int index) {
        return values[index];
    }

    List<T> toList() {
        return Arrays.asList(Arrays.copyOf(values, index));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return index > position;
            }

            @Override
            public T next() {
                if (position >= index) {
                    throw new NoSuchElementException();
                }
                return values[position++];
            }
        };
    }
}
