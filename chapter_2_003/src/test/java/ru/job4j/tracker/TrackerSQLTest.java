package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        ITracker tracker = new TrackerSQL();
        Item item = new Item("1", "2", "");
        item = tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSuccessfullReplaceThenReturnTrue() {
        ITracker tracker = new TrackerSQL();
        Item previous = new Item("test1", "testDescription", "");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", "");
        next.setId(previous.getId());

        assertThat(tracker.replace(previous.getId(), next), is(true));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        ITracker tracker = new TrackerSQL();
        Item previous = new Item("test1", "testDescription", "");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", "");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteThenNeverFind() {
        ITracker tracker = new TrackerSQL();
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
        ITracker tracker = new TrackerSQL();
        tracker.add(new Item("item1", "desc", ""));
        Item item = new Item("item2", "desc", "");
        tracker.add(item);
        tracker.add(new Item("item3", "desc", ""));
        String id = item.getId();

        assertThat(tracker.delete(id), is(true));
    }

    @Test
    public void wenHasOneNameFindItemOfName() {
        ITracker tracker = new TrackerSQL();
        tracker.add(new Item("item1", "description1", ""));
        Item item = new Item("item2", "desc", "503");
        tracker.add(item);
        tracker.add(new Item("item3", "description3", ""));
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertThat(tracker.findByName("item2"), is(items));
    }

    @Test
    public void wenHasTwoNamesFindTwoItemsByNames() {
        ITracker tracker = new TrackerSQL();
        tracker.add(new Item("item1", "description1", ""));
        Item item = new Item("item5", "desc", "");
        tracker.add(item);
        Item item2 = new Item("item5", "description for item2", "");
        tracker.add(item2);
        tracker.add(new Item("item3", "description3", ""));
        tracker.add(new Item("item4", "description4", ""));
        List<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item2);
        assertThat(tracker.findByName("item5"), is(items));
    }

}
