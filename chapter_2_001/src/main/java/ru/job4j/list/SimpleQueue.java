package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack<T> income = new SimpleStack<>();
    private SimpleStack<T> outcome = new SimpleStack<>();

    public void push(T value) {
        if (!outcome.empty()) {
            changeLoad(outcome, income);
        }
        income.push(value);
    }

    public T poll() {
        if (!income.empty()) {
            changeLoad(income, outcome);
        }
        return outcome.poll();
    }

    private void changeLoad(SimpleStack<T> unload, SimpleStack<T> load) {
        while (!unload.empty()) {
            load.push(unload.poll());
        }
    }
}
