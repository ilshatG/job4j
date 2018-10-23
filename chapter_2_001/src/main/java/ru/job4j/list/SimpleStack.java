package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    SimpleArrayList<T> values;
    int count = 0;
    SimpleStack() {
        values = new SimpleArrayList<T>();
    }

    public void push(T item) {
        values.add(item);
        count++;
    }

    public T poll() {
        if (count <= 0) {
            throw new NoSuchElementException();
        }
        T result = values.get(0);
        values.delete();
        return result;
    }
}
