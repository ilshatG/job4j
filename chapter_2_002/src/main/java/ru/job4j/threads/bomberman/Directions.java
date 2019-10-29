package ru.job4j.threads.bomberman;

public enum Directions {Up, Right, Left, Down;
    public static Directions random() {
        Directions values[] = Directions.values();
        return values[(int)(Math.random() * values.length)];
    }
}