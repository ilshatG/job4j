package ru.job4j.threads.bomberman;

import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class Board {
    private final ReentrantLock[][] locks;

    public Board(int rows, int columns) {
        locks = new ReentrantLock[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ReentrantLock lock = new ReentrantLock();
                //lock.lock();
                locks[i][j] = lock;
            }
        }
    }

    public Stream<ReentrantLock> stream() {
        return Arrays.stream(locks).flatMap(Arrays::stream);
    }

    public int getWidth() {
        return locks[0].length;
    }

    public int getHeight() {
        return locks.length;
    }

    public ReentrantLock getLock(Point point) {
        return locks[point.y][point.x];
    }

    public ReentrantLock getLock(int x, int y) {
        return locks[y][x];
    }
}