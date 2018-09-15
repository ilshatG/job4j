package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        return this.filledBy(true, 0, 0, 1, 0)
                || this.filledBy(true, 0, 0, 0, 1)
                || this.filledBy(true, 0, 0, 1, 1)
                || this.filledBy(true, table.length-1, 0, -1, 1)
                || this.filledBy(true, 0, 1, 1, 0)
                || this.filledBy(true, 0, table.length-1, 1, 0)
                || this.filledBy(true, 1, 0, 0, 1)
                || this.filledBy(true, table.length-1, 0, 0, 1);
    }

    public boolean isWinnerO() {
        return this.filledBy(false, 0, 0, 1, 0)
                || this.filledBy(false, 0, 0, 0, 1)
                || this.filledBy(false, 0, 0, 1, 1)
                || this.filledBy(false, table.length-1, 0, -1, 1)
                || this.filledBy(false, 0, 1, 1, 0)
                || this.filledBy(false, 0, table.length-1, 1, 0)
                || this.filledBy(false, 1, 0, 0, 1)
                || this.filledBy(false, table.length-1, 0, 0, 1);
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

    //boolean xOrOchecking для проверки X, если true, иначе O проверяем
    public boolean filledBy(boolean xOrOchecking, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startY][startX];
            if (xOrOchecking) {
                if (!cell.hasMarkX()) {
                    result = false;
                    break;
                }
            } else {
                if (!cell.hasMarkO()) {
                    result = false;
                    break;
                }
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
