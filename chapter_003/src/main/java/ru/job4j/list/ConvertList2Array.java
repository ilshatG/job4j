package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells =  (list.size() + rows - 1) / rows;
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int[] row : array) {
            int i = 0;
            for (int column : row) {
                if (list.size() > index) {
                    row[i++] = list.get(index++);
                } else {
                    break;
                }
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] item : list) {
            for (int element : item) {
                result.add(element);
            }
        }
        return result;
    }

}