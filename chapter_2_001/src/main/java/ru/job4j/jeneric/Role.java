package ru.job4j.jeneric;

public class Role extends Base {
    String description;
    Role(String id) {
        super(id);
    }

    Role(String id, String description) {
        super(id);
        this.description = description;
    }
}
