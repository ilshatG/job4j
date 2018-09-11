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
        //проверяю левую диагональ
        int trueCount = 0; //счетчик всех true
        int falseCount = 0; //счетчик всех fale
        for (int count = 0; count < data.length; count++) {
            if (data[count][count]) {
                trueCount++;
            } else {
                falseCount++;
            }
            //досрочный выход из цикла, если в процессе перебора пошло смешение true и false. Для ускорения работы метода
            if (trueCount * falseCount != 0) {
                break;
            }
        }
        if (trueCount * falseCount != 0) {
            //то дальше и проверять не следует - уходим
            return false;
        }

        //проверяю правую диагональ
        trueCount = 0; //счетчик всех true
        falseCount = 0; //счетчик всех fale
        for (int count = 0; count < data.length; count++) {
            if (data[count][data.length - count - 1]) {
                trueCount++;
            } else {
                falseCount++;
            }
            //досрочный выход из цикла, если в процессе перебора пошло смешение true и false. Для ускорения работы метода
            if (trueCount * falseCount != 0) {
                break;
            }
        }

        return trueCount * falseCount == 0;
    }
}
