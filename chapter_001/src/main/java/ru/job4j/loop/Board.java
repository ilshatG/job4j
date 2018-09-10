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
        for (int rowCount =0; rowCount < height; rowCount++) {
            for (int columnCount = 0; columnCount < width; columnCount++) {
                // условие проверки, что писать пробел или X
                if ( (rowCount + columnCount) % 2 == 0) {
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
