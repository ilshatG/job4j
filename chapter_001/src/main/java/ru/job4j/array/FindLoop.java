package ru.job4j.array;

/**
 * Calculator.
 * Объект данного классна создается для манипулироания массивами и их элементами.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class FindLoop {
    /**
     * Арифметически складывает два значения.
     * @param data массив целых чисел.
     * @param el число для поиска в представленном массиве data.
     * @return номер найденного элемента в массиве. Нумерация начинаетсяс 0.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
