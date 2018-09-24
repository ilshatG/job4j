package ru.job4j.tracker;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;


public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", "123");
        tracker.add(item);
        assertThat(tracker.getItem(0), is(item));
    }

    @Test
    public void whenSuccessfullReplaceThenReturnTrue() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", "123");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", "1234");
        next.setId(previous.getId());

        assertThat(tracker.replace(previous.getId(), next), is(true));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", "123");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", "1234");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteThenNeverFind() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1", "desc", ""));
        Item item = new Item("item2", "desc", "");
        tracker.add(item);
        tracker.add(new Item("item3", "desc", ""));
        String id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is((Item) null));
    }

    @Test
    public void whenDeleteFoundItemThenTrue() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1", "desc", ""));
        Item item = new Item("item2", "desc", "");
        tracker.add(item);
        tracker.add(new Item("item3", "desc", ""));
        String id = item.getId();

        assertThat(tracker.delete(id), is(true));
    }

    @Test
    public void wenHasOneNameFindItemOfName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1", "description1", ""));
        Item item = new Item("item2", "desc", "");
        tracker.add(item);
        tracker.add(new Item("item3", "description3", ""));
        Item[] items = new Item[1];
        items[0] = item;
        assertThat(tracker.findByName("item2"), is(items));
    }

    @Test
    public void wenHasTwoNamesFindTwoItemsByNames() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1", "description1", ""));
        Item item = new Item("item2", "desc", "");
        tracker.add(item);
        Item item2 = new Item("item2", "description for item2", "");
        tracker.add(item2);
        tracker.add(new Item("item3", "description3", ""));
        tracker.add(new Item("item4", "description4", ""));
        Item[] items = new Item[2];
        items[0] = item;
        items[1] = item2;

        assertThat(tracker.findByName("item2"), is(items));
    }

}