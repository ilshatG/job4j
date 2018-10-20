package ru.job4j.iterator;

import java.util.Iterator;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iterator = it.next();
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                Integer result = 0;
                changeIteratorIfNesesery();
                result = iterator.next();
                changeIteratorIfNesesery();
                return result;
            }

            void changeIteratorIfNesesery() {
                if (!iterator.hasNext() && it.hasNext()) {
                    iterator = it.next();
                }
                return;
            }
        };
    }
}