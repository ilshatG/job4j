package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return this.filledByX(0, 0, 1, 0)
                || this.filledByX(0, 0, 0, 1)
                || this.filledByX(0, 0, 1, 1)
                || this.filledByX(2, 0, -1, 1)
                || this.filledByX(0, 1, 1, 0)
                || this.filledByX(0, 2, 1, 0)
                || this.filledByX(1, 0, 0, 1)
                || this.filledByX(2, 0, 0, 1);
    }

    public boolean isWinnerO() {
        return this.filledByO(0, 0, 1, 0)
                || this.filledByO(0, 0, 0, 1)
                || this.filledByO(0, 0, 1, 1)
                || this.filledByO(2, 0, -1, 1)
                || this.filledByO(0, 1, 1, 0)
                || this.filledByO(0, 2, 1, 0)
                || this.filledByO(1, 0, 0, 1)
                || this.filledByO(2, 0, 0, 1);
    }
/* с предикатами. оставлено на будущее
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, 2, 0, -1, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1);
    }
*/
    public boolean hasGap() {
        boolean result = false;
        for (Figure3T[] figure:table) {
            for (Figure3T cell:figure) {
                if (!(cell.hasMarkX() || cell.hasMarkO())) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    public boolean filledByX(int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            if (!this.table[startX][startY].hasMarkX()) {
                result = false;
                break;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return result;
    }

    public boolean filledByO(int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            if (!this.table[startX][startY].hasMarkO()) {
                result = false;
                break;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return result;
    }

    /* С предикатом. Оставлено на будущее
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }*/
}
