package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class OccupiedWayException extends RuntimeException {
    OccupiedWayException(String msg) {
        super(msg);
    }
}
