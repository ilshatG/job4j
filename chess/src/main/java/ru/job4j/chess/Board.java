package ru.job4j.chess;

import javafx.scene.control.Alert;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    private final Figure[] figures = new Figure[32];
    private int index = 0;
    private int size = 8;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("there's nothing to move, dude");
        }
        Cell[] steps;
        try {
            steps = this.figures[index].way(source, dest);
        } catch (ImpossibleMoveException e) {
            throw new ImpossibleMoveException("impossible way");
        }
        for (int i = 0; i < steps.length; i++) {
            if (findBy(steps[i]) != -1) {
                throw new OccupiedWayException("the way is occupied");
            }
        }
        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
