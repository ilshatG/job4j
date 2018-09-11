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
        //посчитаю все true и false в массиве. Если то, или иное будет равно 0 в конечном итоге, то все члены равны.
        int trueCount = 0; //счетчик всех true
        int falseCount = 0; //счетчик всех fale
        for (boolean value: data) {
            if (value) {
                trueCount++;
            } else {
                falseCount++;
            }
        }
        return trueCount * falseCount == 0;
    }

}
