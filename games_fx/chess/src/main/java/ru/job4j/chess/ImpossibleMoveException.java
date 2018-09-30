package ru.job4j.chess;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException() {
        System.out.println("impossible move!");
    }
}
