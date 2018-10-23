package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<T> implements Iterable {
    SimpleArrayList<T> values = new SimpleArrayList<>();
    int modCount = 0;

    public void add(T value) {
        values.add(value);
        modCount++;
    }

    public T get(int index) {
        return values.get(index);
    }

    public int getSize() {
        return values.getSize();
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                checkModification();
                return index < values.getSize();
            }

            @Override
            public T next() {
                checkModification();
                if (index >= values.getSize()) {
                    throw new NoSuchElementException();
                }
                return values.get(index++);
            }

            private void checkModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
            };
    }
}
