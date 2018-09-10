package ru.job4j.array;

/**
 * Объект данного классна создается для работы с массивами.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class Square {

    /**
     * Заполняет массив квардатами индесов элементов.
     * @param bound верхняя граница массива.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int index = 0; index < bound; index++) {
            rst[index] = (int) Math.pow(index + 1, 2);
        }
        return rst;
    }
}
