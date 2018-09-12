package ru.job4j.array;
/**
 * Объект данного классна создается для реализации матрицы и заполнения ее таблицей умножения.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class Matrix {
    /**
     * Заполнение матрицы таблицей умножения.
     * @param size размер матрицы.
     * @return двумерный массив, заполненный таблицей умножения.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                table[row][column] = (row + 1) * (column + 1);
            }
        }
        return table;
    }
}