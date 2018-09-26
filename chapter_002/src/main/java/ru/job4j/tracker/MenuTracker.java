package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

class FindItemById implements UserAction {
    private int key;
    private String info;

    FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return this.info;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("-------- Поиск заявок по id ----------");
        String id = input.ask("Введите id заявки");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с данным id не найдена");
        }
    }
}

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавить новую заявку"));
        this.actions.add(new ShowItems(1, "Показать все заявки"));
        this.actions.add(new MenuTracker.EditItem(2, "Редактировать заявку"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удалить заявку"));
        this.actions.add(new FindItemById(4, "Найти заявку по Id"));
        this.actions.add(new FindItemsByName(5, "Найти заявки по имени"));
        this.actions.add(new ExitProgram(6, "Выйти из программы"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.key() + ". " + action.info());
            }
        }
    }

    class AddItem implements UserAction {
        private int key;
        private String info;

        AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return this.info;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");

        }
    }

    class ShowItems implements UserAction {
        private int key;
        private String info;

        ShowItems(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return this.info;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список всех заявок --------------");
            for (Item element : tracker.findAll()) {
                System.out.println(element);
            }
            System.out.println("--------------- Конец списка -----------------");
        }
    }

    static class EditItem implements UserAction {
        private int key;
        private String info;

        EditItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return this.info;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------- Изменить существующую заявку ----------");
            String id = input.ask("Введите id существующей заявки");
            String name = input.ask("Введите новое имя заявки");
            String desc = input.ask("Введите новое описание заявки :");
            Item replace = new Item(name, desc, id);
            if (tracker.replace(id, replace)) {
                System.out.println("Заявка изменена");
            } else {
                System.out.println("Заявка с данным id не найдена");
            }
        }
    }

    static class DeleteItem implements UserAction {
        private int key;
        private String info;

        DeleteItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return this.info;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------- Удалить существующую заявку ----------");
            String id = input.ask("Введите id заявки");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена");
            } else {
                System.out.println("Заявка с данным id не найдена");
            }
        }
    }

    class FindItemsByName implements UserAction {
        private int key;
        private String info;

        FindItemsByName(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return this.info;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------- Поиск заявок по имени ----------");
            String name = input.ask("Введите имя заявки");
            System.out.println("------------ Список всех заявок --------------");
            boolean found = false;
            for (Item element : tracker.findByName(name)) {
                System.out.println(element);
                found = true;
            }
            System.out.println("--------------- Конец списка -----------------");
            if (!found) {
                System.out.println("Заявок с данным именем не найдено");
            }
        }
    }

    class ExitProgram implements UserAction {
        private int key;
        private String info;

        ExitProgram(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return this.info;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            exit(0);
        }
    }
}
