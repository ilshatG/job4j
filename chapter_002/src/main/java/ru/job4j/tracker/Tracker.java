package ru.job4j.tracker;
import java.util.Date.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int index = 0; index < items.length - 1; index++) {
            if (item != null && items[index].getId().equals(id)) {
                result = true;
                items[index] = item;
                items[index].setId(id);
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
        int index = 0;
        for (Item element : this.items) {
            if (element != null && element.getId().equals(id)) {
                result = true;
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                this.items[this.items.length - 1] = null;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Метод реализаущий получение всех заявок
     * @return массив со всеми заявками без пустых элементов
     */
    public Item[] findAll() {
        Item[] temp = new Item[100];
        int index = 0;
        for (Item element : this.items) {
            if (element != null) {
                temp[index++] = element;
            }
        }
        Item[] result = new Item[index];
        System.arraycopy(temp, 0, result, 0, index);
        return result;

    }

    /**
     * Метод реализаущий получение заявок по имени.
     * @param key имя в заявке
     * @return массив со всеми заявками, удовлетворяющих условию по равенству имени
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[100];
        int index = 0;
        for (Item element : this.items) {
            if (element != null && element.getName().equals(key)) {
                temp[index++] = element;
            }
        }
        Item[] result = new Item[index];
        System.arraycopy(temp, 0, result, 0, index);
        return result;
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
        return items[index];
    }

    /**
     * Возвращает список всех заявок.
     * @return массив заявок.
     */
    Item[] getAll() {
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