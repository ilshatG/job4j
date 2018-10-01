package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ChessTest {
    @Test
    public void fromA1toH8() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] actual = bishop.way(bishop.position(), Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void fromH8toA1() {
        BishopBlack bishop = new BishopBlack(Cell.H8);
        Cell[] actual = bishop.way(bishop.position(), Cell.A1);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1};
        assertThat(actual, is(expected));
    }

    @Test
    public void fromH1toA8() {
        BishopBlack bishop = new BishopBlack(Cell.H1);
        Cell[] actual = bishop.way(bishop.position(), Cell.A8);
        Cell[] expected = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        assertThat(actual, is(expected));
    }

    @Test
    public void fromA8toH1() {
        BishopBlack bishop = new BishopBlack(Cell.A8);
        Cell[] actual = bishop.way(bishop.position(), Cell.H1);
        Cell[] expected = {Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1};
        assertThat(actual, is(expected));
    }
}