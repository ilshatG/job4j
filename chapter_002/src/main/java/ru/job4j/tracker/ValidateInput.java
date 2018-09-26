package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Введите корректный пункт меню");
            } catch (NumberFormatException e) {
                System.out.println("Неверные данные. Повторите ввод.");
            }
        } while (invalid);
        return value;
    }
}
