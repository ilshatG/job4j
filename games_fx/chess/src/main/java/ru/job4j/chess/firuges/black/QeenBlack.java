package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenBlack extends Figure {
    public QeenBlack(final Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] { dest };
    }

    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
