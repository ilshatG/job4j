package ru.job4j.loop;

/**
 * Крестики нолики.
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * Возвращает начальную доску с крестиками ноликами .
     * @param width ширина доски. Нумерация колонок доски начинается с 1.
     * @param height высота доски. Нумерация строк доски начинается с 1.
     * @return сумма четных чисел.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                // условие проверки, что писать пробел или X
                if ((row + column) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }

}
