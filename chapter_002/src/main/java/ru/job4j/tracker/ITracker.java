package ru.job4j.tracker;

import java.util.List;

public interface ITracker {
    Item add(Item item);
    boolean replace(String id, Item item);
    boolean delete(String id);
    List<Item> findAll();//Item[]
    List<Item> findByName(String key);//Item[]
    Item findById(String id);
}
