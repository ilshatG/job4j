package ru.job4j.jeneric;

public class User extends Base {
    private String description;

    User(String id) {
        super(id);
    }

    User(String id, String description) {
        super(id);
        this.description = description;
    }

}
