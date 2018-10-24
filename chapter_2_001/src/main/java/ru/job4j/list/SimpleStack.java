package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private SimpleArrayList<T> values;
    private int count = 0;
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
        count--;
        return result;
    }

    private int getSize() {
        return count;
    }
    public boolean empty() {
        return count == 0;
    }
}
