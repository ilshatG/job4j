package ru.job4j.set;

import ru.job4j.list.GrowableList;
import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private GrowableList<T> values = new GrowableList<>();

    public boolean add(T value) {
        boolean result = false;
        if (!exist(value)) {
            values.add(value);
            result = true;
        }
        return result;
    }

    private boolean exist(T value) {
        boolean result = false;
        for (T item : values) {
            if (value.equals(item)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }
}
