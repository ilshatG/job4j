package ru.job4j.threads.monitor;

import ru.job4j.list.GrowableList;

import java.util.Iterator;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ThreadSafeList<T> implements Iterable<T>{
    @GuardedBy("this")
    private GrowableList<T> array = new GrowableList<>();

    public synchronized void add(T item) {
        array.add(item);
    }

    public synchronized T get(int index) {
        return array.get(index);
    }

    private GrowableList<T> copy(GrowableList<T> values) {
        GrowableList<T> result = new GrowableList<>();
        for(T value: values) {
            result.add(value);
        }
        return result;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.array).iterator();
    }
}
