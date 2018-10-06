package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void showAllOrders() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", "");
        Item item2 = new Item("test2", "testDescription2", "");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                                                        .append(menuToString())
                                                        .append("------------ Список всех заявок --------------" + System.lineSeparator())
                                                        .append(item1.getId() + "\t\t" + "test1" + "\t\ttestDescription1" + System.lineSeparator())
                                                        .append(item2.getId() + "\t\t" + "test2" + "\t\ttestDescription2" + System.lineSeparator())
                                                        .append("--------------- Конец списка -----------------")
                                                        .append(System.lineSeparator()).toString()
                                                        )
        );
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", "");
        Item item2 = new Item("test2", "testDescription2", "");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"4", item1.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                                                        .append(menuToString())
                                                        .append("-------- Поиск заявок по id ----------")
                                                        .append(System.lineSeparator())
                                                        .append(item1.getId() + "\t\t" + "test1" + "\t\ttestDescription1" + System.lineSeparator())
                                                        .toString()
                )
        );
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", "");
        Item item2 = new Item("test2", "testDescription2", "");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"5", item1.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(new StringBuilder()
                        .append(menuToString())
                        .append("-------- Поиск заявок по имени ----------")
                        .append(System.lineSeparator())
                        .append("------------ Список всех заявок --------------")
                        .append(System.lineSeparator())
                        .append(item1.getId() + "\t\t" + "test1" + "\t\ttestDescription1" + System.lineSeparator())
                        .append("--------------- Конец списка -----------------")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteThenTrackerHasNoValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        String id = item.getId();
        Input input = new StubInput(new String[]{"3", id, "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере не содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(id), is((Item) null));
    }

    String menuToString() {
        return new StringBuilder()
                .append("0 : Добавить новую заявку" + System.lineSeparator())
                .append("1 : Показать все заявки" + System.lineSeparator())
                .append("2 : Редактировать заявку" + System.lineSeparator())
                .append("3 : Удалить заявку" + System.lineSeparator())
                .append("4 : Найти заявку по Id" + System.lineSeparator())
                .append("5 : Найти заявки по имени" + System.lineSeparator())
                .append("6 : Выйти из программы"  + System.lineSeparator())
                .toString();
    }
}