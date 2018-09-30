package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class OccupiedWayException extends RuntimeException {
    OccupiedWayException(Cell[] steps){
        for (Cell cell : steps) {
            System.out.println(cell);
        }
    }
}
