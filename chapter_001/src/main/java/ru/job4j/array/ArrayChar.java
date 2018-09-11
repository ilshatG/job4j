package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     * Если префикс длиннее, то напротив проверяется начинание префикса с имеющимся более коротким массивом data.
     * Если префикс, или(и) строка пустые, то true.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value
        //для предотвращения arrayIndexOutOfBounds добавлена еще одна проверка в объявлении цикла.
        // Благодаря ей префикс и проверяемая строка как бы меняются местами, если первый длиннее.
        for (int index = 0; index < value.length & index < data.length; index++) {
            if (data[index] != value[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
