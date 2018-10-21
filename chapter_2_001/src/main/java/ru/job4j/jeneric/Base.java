package ru.job4j.jeneric;

public class Base<T> {
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
