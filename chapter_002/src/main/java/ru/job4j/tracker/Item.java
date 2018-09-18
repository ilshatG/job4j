package ru.job4j.tracker;

public class Item {
    private String name;
    private String desc;
    private String id;
    private long created;
    private String[] comments;

    Item(String name, String desc, String id) {
        this.name = name;
        this.desc = desc;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
