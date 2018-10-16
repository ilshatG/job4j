package ru.job4j.tracker;
import java.util.*;
import java.util.function.Consumer;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    Consumer write;

    public ConsoleInput() {
        write = (s) -> System.out.println(s);
    }

    public ConsoleInput(Consumer write) {
        this.write = write;
    }

    public String ask(String question) {
        write.accept(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Неверное значение");
        }
        return key;
    }
}
