package ru.job4j.loop;

/**
 * Рисование на виртуальной доске с применением циклов
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
 * @version $Id$
 * @since 0.1
 */

public class Paint {

    /**
     * Возвращает изображение пирамиды на виртуальной доске в виде строки.
     * @param height высота доски. Нумерация строк доски начинается с 1.
     * @return изображение пирамиды из сиволов ^ в строке.
     */

    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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

