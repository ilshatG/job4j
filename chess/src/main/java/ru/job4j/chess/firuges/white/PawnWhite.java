package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite extends Figure {

    public PawnWhite(final Cell position) {
        super(position);
    }

    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] {dest};
    }

    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
