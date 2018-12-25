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
        if (value.length > data.length || value.length == 0) {
            return false;
        }
        for (int index = 0; index < value.length; index++) {
            if (data[index] != value[index]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String action ="delete id=12345";
        String id ="";
        if (action.contains("delete")) {
            id = action.substring(10, action.length());
            action="delete";
            //user = new User(Integer.parseInt(id), name, login, email, createDate);
            System.out.println(action);
            System.out.println(id);
        }

    }
}
