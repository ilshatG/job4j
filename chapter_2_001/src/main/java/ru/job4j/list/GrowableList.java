package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GrowableList<T> implements Iterable<T> {
    private final static int INITIAL_ARRAY_SIZE = 3;
    private final static int INCREASING_ARRAY_STEP = 3;
    private T[] container;
    private int index = 0;
    private int modCount = 0;

    public GrowableList() {
        container = (T[]) new Object[INITIAL_ARRAY_SIZE];
    }

    public GrowableList(int size) {
        container = (T[]) new Object[size];
    }

    public void add(T item) {
        needForArraySizeIncrease();
        container[index++] = item;
        modCount++;
    }

    T get(int index) {
        if (index > this.index || index < 0) {
            throw new NoSuchElementException();
        }
        return container[index];
    }

    private void needForArraySizeIncrease() {
        if (container.length < index + 1) {
            T[] newContainer = Arrays.copyOf(container, container.length + INCREASING_ARRAY_STEP);
            container = newContainer;
        }
    }

    public int getRealSize() {
        return container.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int position = 0;
            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                checkModification();
                return index > position;
            }

            @Override
            public T next() {
                checkModification();
                if (position >= index) {
                    throw new NoSuchElementException();
                }
                return container[position++];
            }

            private void checkModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
