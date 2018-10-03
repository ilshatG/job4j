package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("impossible move");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        for (int index = 0; index  < Math.abs(source.x - dest.x); index++) {
            steps[index] = Cell.valueOf((char) ('A' + source.x + index * deltaX + deltaX) + "" + (source.y + index * deltaY + 1 + deltaY));
        }
        return steps;
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }

}
