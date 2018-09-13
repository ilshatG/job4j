package ru.job4j.array;

/**
 * Объект данного классна создается для реализации матрицы и операций над ней.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class MatrixCheck {

    /**
     * Проверка матрицы на предмет равенства элементов по диагоналям.
     * @param data матрица - массив с равными размерностями.
     * @return true, если элементы левой диагонали равны, а также элементы правой диагонали равны.
     * Взаимное раверство элементов различных диагоналей не обязательно.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public boolean mono(boolean[][] data) {

        int size = data.length;
        boolean firstLeft = data[0][0];
        boolean firstRight = data[0][size - 1];
        boolean result = true;

        for (int index = 0; index < size; index++) {
            if (data[index][index] != firstLeft
                    || data[index][size - index - 1] != firstRight) {
                result = false;
                break;
            }
        }
        return result;
    }
}
