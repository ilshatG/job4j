package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех значений.
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа меню для редактирования значений.
     */
    private static final String REPLACE = "2";

    /**
     * Константа меню для удаления значений.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска значений по id.
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа меню для поиска значений по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.showById();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.showByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует показ всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Список всех заявок --------------");
        for (Item element : tracker.findAll()) {
            System.out.println(element);
        }
        System.out.println("--------------- Конец списка -----------------");
    }

    /**
     * Метод реализует редактирование заявки.
     */
    void replaceItem() {
        System.out.println("-------- Изменить существующую заявку ----------");
        String id = this.input.ask("Введите id существующей заявки");
        String name = this.input.ask("Введите новое имя заявки");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item replace = new Item(name, desc, id);
        if (this.tracker.replace(id, replace)) {
            System.out.println("Заявка изменена");
        } else {
            System.out.println("Заявка с данным id не найдена");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    void deleteItem() {
        System.out.println("-------- Удалить существующую заявку ----------");
        String id = this.input.ask("Введите id заявки");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка с данным id не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    void showById() {
        System.out.println("-------- Поиск заявок по id ----------");
        String id = this.input.ask("Введите id заявки");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с данным id не найдена");
        }
    }

    /**
     * Метод реализует поиск заявок по имени.
     */
    void showByName() {
        System.out.println("-------- Поиск заявок по имени ----------");
        String name = this.input.ask("Введите имя заявки");
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

    private void showMenu() {
        System.out.println(System.lineSeparator());
        System.out.println("Меню");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по Id");
        System.out.println("5. Найти заявки по имени");
        System.out.println("6. Выйти из программы");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}