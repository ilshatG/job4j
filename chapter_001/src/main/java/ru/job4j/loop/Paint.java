package ru.job4j.loop;
import java.util.function.BiPredicate;

/**
 * Рисование на виртуальной доске с применением циклов
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
 * @version $Id$
 * @since 0.1
 */

public class Paint {

        public String rightTrl(int height) {
            return this.loopBy(
                    height,
                    height,
                    (row, column) -> row >= column
            );
        }

        public String leftTrl(int height) {
            return this.loopBy(
                    height,
                    height,
                    (row, column) -> row >= height - column - 1
            );
        }

    /**
     * Возвращает изображение пирамиды на виртуальной доске в виде строки.
     * @param height высота доски. Нумерация строк доски начинается с 1.
     * @return изображение пирамиды из сиволов ^ в строке.
     */

        public String pyramid(int height) {
            return this.loopBy(
                    height,
                    2 * height - 1,
                    (row, column) -> row >= height - column - 1 && row + height - 1 >= column
            );
        }

        private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
            StringBuilder screen = new StringBuilder();
            for (int row = 0; row != height; row++) {
                for (int column = 0; column != weight; column++) {
                    if (predict.test(row, column)) {
                        screen.append("^");
                    } else {
                        screen.append(" ");
                    }
                }
                screen.append(System.lineSeparator());
            }
            return screen.toString();
        }
    }

