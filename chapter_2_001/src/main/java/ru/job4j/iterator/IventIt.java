package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IventIt implements Iterator {
    private int[] values;
    private int index = 0;

    public IventIt(int[] values) {
        this.values = values;
        if (values.length > 0 && values[0] % 2 != 0) {
            index = nextEven();
        }
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public Object next() {
        if (index >= values.length) {
            throw new NoSuchElementException();
        }
        int result = values[index];
        index = nextEven();
        return result;
    }

    private int nextEven() {
        int i = index + 1;
        while ((i < values.length) && (values[i] % 2 != 0)) {
            i++;
        }
        int result = values.length;
        if (i < values.length) {
            result = i;
        }
        return result;
    }
}
