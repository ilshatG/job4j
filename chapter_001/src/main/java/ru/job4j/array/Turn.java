package ru.job4j.array;

/**
 *
 * Объект данного классна создается для манипулироания массивами и их элементами.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class Turn {

    /**
     * @param array массив целых чисел.
     * @return перевернутый массив.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public int[] turn(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
