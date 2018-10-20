package ru.job4j.iterator;

import java.util.Iterator;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iterator = it.next();
            @Override
            public boolean hasNext() {
                changeIteratorIfNesessary();
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                Integer result = 0;
                changeIteratorIfNesessary();
                result = iterator.next();
                changeIteratorIfNesessary();
                return result;
            }

            void changeIteratorIfNesessary() {
                while (!iterator.hasNext() && it.hasNext()) {
                    iterator = it.next();
                }
                return;
            }
        };
    }
}