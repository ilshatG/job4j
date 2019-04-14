package ru.job4j;

import org.springframework.stereotype.Component;

public class JdbcStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println("stored to JDBC");
    }
}
