package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int duplicates = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - duplicates; j++) {
                if (array[i].equals(array[j])) {
                    while (j != array.length - duplicates - 1
                            && array[array.length - duplicates - 1].equals(array[j])) {
                        duplicates++;
                    }
                    String tmp = array[array.length - duplicates - 1];
                    array[array.length - duplicates - 1] = array[j];
                    array[j] = tmp;
                    duplicates++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - duplicates);
    }
}
