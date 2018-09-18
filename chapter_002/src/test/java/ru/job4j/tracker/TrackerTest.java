package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", "123");
        tracker.add(item);
        assertThat(tracker.getItem(0), is(item));
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
    public void findByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("item1", "description1", ""));
        Item item = new Item("item2", "desc", "");
        tracker.add(item);
        tracker.add(new Item("item3", "description3", ""));
        Item[] items = new Item[100];
        items[0] = item;
        assertThat(tracker.findByName("item2"), is(items));
    }
}