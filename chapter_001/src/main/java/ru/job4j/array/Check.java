package ru.job4j.array;
/**
 *
 * Объект данного классна создается для манипулироания массивами и их элементами.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
*/
public class Check {
    /**
     * Определение равенства каждого из элементов в массиве.
     * @param data массив значений.
     * @return true если все элементы равны.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean firstValue = data[0];
        for (boolean value: data) {
            if (value != firstValue) {
                result = false;
                break;
            }
        }
        return result;
    }
}
