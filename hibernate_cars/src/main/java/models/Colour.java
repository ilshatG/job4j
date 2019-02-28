package models;

/**
 * car's colour
 */
public class Colour {
    private long id;
    private String name;

    public Colour() {
    }

    public Colour(String name) {
        this.name = name;
    }

    public Colour(long id) {
        this.id = id;
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
