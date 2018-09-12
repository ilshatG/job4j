package ru.job4j.array;

/**
 * Объект данного классна создается для сортировкии массива.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
*/
public class BubbleSort {
    /**
     * Пузырьковая сортировка от минимального к максимальному.
     * @param array массив значений.
     * @return отсортированный массив.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public int[] sort(int[] array) {
        for (int pass = 0; pass < array.length - 1; pass++) {
            for (int index = 0; index < array.length - 1 - pass; index++) {
                if (array[index] >  array[index + 1]) {
                    int swap = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = swap;
                }
            }
        }
        return array;
    }
}
