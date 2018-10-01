package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class Figure {
    private final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public Cell position() {
        return position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    public abstract Figure copy(Cell dest);

}
