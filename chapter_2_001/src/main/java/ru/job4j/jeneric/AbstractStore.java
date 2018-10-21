package ru.job4j.jeneric;

import ru.job4j.iterator.SimpleArray;

public class AbstractStore<T extends Base> implements Store<T> {
    SimpleArray<T> values;

    public AbstractStore(int size) {
        values = new SimpleArray<>(size);
    }

    public AbstractStore() {
        values = new SimpleArray<>(10);
    }

    @Override
    public void add(T model) {
        values.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexById(id);
        if (index != -1) {
            values.set(index, model);
        }
        return index != -1;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            values.delete(index);
        }
        return index != -1;
    }

    @Override
    public T findById(String id) {
        int index = findIndexById(id);
        T result = null;
        if (index != -1) {
            result = values.get(index);
        }
        return result;
    }

    private int findIndexById(String id) {
        int index = 0;
        boolean found = false;
        for (Base value: values) {
            if (value.getId().equals(id)) {
                found = true;
                break;
            }
            index++;
        }
        return found ? index : -1;
    }
}
