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
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализаущий редактирование заявки
     * @param item новая заявка
     * @param id идентификационный номер заявки
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < items.length - 1; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                items[index].setId(id);
                break;
            }
        }
    }

    /**
     * Метод реализаущий удаление заявки
     * @param id идентификационный номер заявки
     */
    public void delete(String id) {
        int index = 0;
        for (Item element : this.items) {
            if (element.getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                this.items[this.items.length - 1] = null;
                break;
            }
            index++;
        }
    }

    /**
     * Метод реализаущий получение всех заявок
     * @return массив со всеми заявками
     */
    public Item[] findAll() {
        return items;
    }

    /**
     * Метод реализаущий получение заявок по имени
     * @param key имя в заявке
     * @return массив со всеми заявками, удовлетворяющих условию по равенству имени
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int index = 0;
        for (Item element : this.items) {
            if (element != null && element.getName().equals(key)) {
                result[index++] = element;
            }
        }
        return result;
    }

    /**
     * Метод реализаущий получение заявки по имени
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
     * @param index номер заявки в списке
     * @return заявка
     */
    public Item getItem(int index) {
        return items[index];
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return Math.round(Math.random() * 1000) + "" + System.currentTimeMillis();
    }
}