package ru.job4j.array;

/**
 * Класс, содержащий метод соединения сортированных массивов.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class mergeSortedArrays {
    /**
     * Соединение двух отсортированных массивов в один отсортированный.
     * @param array1 - исходный отсортированный массив целых чисел.
     * @param array2 - исходный отсортированный массив целых чисел.
     * @return результирующий отсортированный массив целых чисел.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */
    public static int[]  mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int index1 = array1.length - 1;
        int index2 = array2.length - 1;
        for (int i = array1.length + array2.length -1; i >= 0; i--) {
            if ((index1 >= 0 ? array1[index1] : 0) > (index2 >= 0 ? array2[index2] : 0)) {
                result[i] = index1 >= 0 ? array1[index1--] : array1[0];
            } else {
                result[i] = index2 >= 0 ? array2[index2--] :  array2[0];
            }
        }
        return result;
    }
}
