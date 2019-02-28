package models;

public class Wheel {
    private long id;
    private String name;

    public Wheel() {
    }

    public Wheel(long id) {
        this.id = id;
    }

    public Wheel(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
