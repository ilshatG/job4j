package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, Cloneable {

    private Connection connection;


    public boolean init() {

        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("username"),
                    config.getProperty("password"),
                    config.getProperty("url")
            );

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public Item add(Item item) {
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        return true;
    }

    @Override
    public boolean delete(String id) {
        return true;
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<Item>();
    }

    @Override
    public List<Item> findByName(String key) {
        return new ArrayList<Item>();
    }

    @Override
    public Item findById(String id) {
        return null;
    }
}
