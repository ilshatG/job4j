package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Date.*;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker implements ITracker {
    /**
     * Массив для хранения заявок.
     */
    private List<Item> items = new ArrayList<>();

    private BiPredicate<Integer, String> conditionId = (index, id) -> {
        return items.get(index).getId().equals(id);
    };

    private BiPredicate<Integer, String> conditionName = (index, id) -> {
        return items.get(index).getName().equals(id);
    };

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод реализаущий замену заявки.
     * @param item новая заявка.
     * @param id идентификационный номер искомой заявки.
     * @return true если успешно
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < items.size(); index++) {
                if (conditionId.test(index, id)) {
                item.setId(id);
                items.set(index, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод реализаущий удаление заявки.
     * @param id идентификационный номер заявки.
     * @return true если успешно
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < items.size(); index++) {
                if (conditionId.test(index, id)) {
                items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод реализаущий получение всех заявок
     * @return массив со всеми заявками без пустых элементов
     */
    public List<Item> findAll() {
        return this.items;

    }

    /**
     * Метод реализаущий получение заявок по имени.
     * @param key имя в заявке
     * @return массив со всеми заявками, удовлетворяющих условию по равенству имени
     */
    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (int index = 0; index < items.size(); index++) {
                if (conditionName.test(index, key)) {
                temp.add(items.get(index));
            }
        }
        return temp;
    }

    /**
     * Метод реализаущий получение заявки по имени.
     * @return заявк
     */
    public Item findById(String id) {
        Item result = null;
        for (Item element: this.items) {
            if (element != null && element.getId().equals(id)) {
                result = element;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @param index номер заявки в списке.
     * @return заявка
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    /**
     * Возвращает список всех заявок.
     * @return массив заявок.
     */
    List<Item> getAll() {
        return items;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return Math.round(Math.random() * 1000) + "" + System.currentTimeMillis();
    }
}