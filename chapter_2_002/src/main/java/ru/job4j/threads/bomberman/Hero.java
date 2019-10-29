package ru.job4j.threads.bomberman;

import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Hero {
    private final Board board;
    private final AtomicInteger currentPosition = new AtomicInteger();

    public Hero(Board board) {
        this.board = board;
        currentPosition.set(-1);
        //setToRandomCell();
    }

    /**
     * Метод ставит героя в произвольную клетку поля. Если клетка занята, то производятся еще попытки,
     * число которых ограничено общим количеством клеток во второй степени.
     */
    public synchronized void setToRandomCell() {
        List<ReentrantLock> boardAsList = board.stream().collect(Collectors.toList());
        boolean result = false;
        long counter = boardAsList.size() * boardAsList.size();
        while (!result && counter > 0) {
            int randomSell = (int)(Math.random()*boardAsList.size());
            if(!boardAsList.get(randomSell).isLocked()) {
                boardAsList.get(randomSell).lock();
                currentPosition.set(randomSell);
                result = true;
            }
        }
    }

    /**
     * Установка героя в клетку с заданными координатами
     * @param point координаты
     * @return
     */
    public synchronized boolean setToPoint(Point point) {
        if (point.x > -1 && point.y > -1 && point.x < board.getWidth() && point.y < board.getHeight() &&
                !board.getLock(point).isLocked()) {
            board.getLock(point).lock();
            currentPosition.set(point.y * board.getWidth() + point.x);
            return true;
        }
        return false;
    }

    public boolean setToPoint(int x, int y) {
        return setToPoint(new Point(x, y));
    }

    public int getPosition() {
        return currentPosition.get();
    }

    public Point getCurrentPoint() {
        return getPoint(getPosition());

    }

    /**
     * Перевод порядкового номера ячейки в виде двух чисел координат x, y
     * @param position
     * @return
     */
    public Point getPoint(int position) {
        Point result = new Point();
        result.x = (position) % board.getWidth();
        result.y = (position / board.getWidth());
        return result;
    }

    public Dimension getDimension() {
        Dimension result = new Dimension();
        result.height = board.getHeight();
        result.width = board.getWidth();
        return result;
    }


    public boolean move(Directions direction) {
        boolean result = false;
        Point currentPoint = getCurrentPoint();
        switch (direction) {
            case Up:
                result = setToPoint(currentPoint.x, currentPoint.y - 1);
                break;
            case Down:
                result = setToPoint(currentPoint.x, currentPoint.y + 1);
                break;
            case Right:
                result = setToPoint(currentPoint.x + 1, currentPoint.y);
                break;
            case Left:
                result = setToPoint(currentPoint.x - 1, currentPoint.y);
                break;
        }
        if(result) {
            board.getLock(currentPoint).unlock();
        }
        return result;
    }

}
