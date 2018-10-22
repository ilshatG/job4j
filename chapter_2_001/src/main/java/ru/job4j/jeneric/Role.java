package ru.job4j.jeneric;

public class Role extends Base {
    private String description;
    Role(String id) {
        super(id);
    }

    Role(String id, String description) {
        super(id);
        this.description = description;
    }
}
