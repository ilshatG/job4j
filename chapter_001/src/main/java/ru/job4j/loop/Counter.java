package ru.job4j.loop;

/**
 * Операции с массивами.
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    int[] values;

    Counter(int[] values) {
        this.values = values;
    }

    /**
     * Возвращает сумму четных чисел массива.
     * @param start начальная позиция массива с которой суммировать четные значения.
     * @param finish конечная позиция до которой суммировать значения в массиве.
     * @return сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int index = start; index <= finish; index++) {
            sum += values[index] % 2 == 0 ? values[index] : 0;
        }
        return sum;
    }
}
