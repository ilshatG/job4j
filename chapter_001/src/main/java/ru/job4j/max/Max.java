package ru.job4j.max;


/**
* @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
* @version $Id$
* @since 0.1
*/
public class Max {
    /**
     * Возвращает максимальное значение из двух заданных.
     * @param first первое значение.
     * @param second второе значение.
     * @return Максимумальное из двух заданных значений.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
