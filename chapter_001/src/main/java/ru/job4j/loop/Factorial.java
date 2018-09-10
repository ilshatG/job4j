package ru.job4j.loop;

/**
 * Операции циклами.
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {

    /**
     * Возвращает факториал заданного числа.
     * @param n число, для которого нужно вычислить факториал.
     * @return факториал.
     */
    public int calc(int n) {
        int result = 1;
        for(int counter = 1; counter <= n; counter++){
            result *= counter;
        }
        return result;
    }
}
