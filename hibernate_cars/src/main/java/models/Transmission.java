package models;

/**
 * Transmission. КПП
 */
public class Transmission {
    private long id;
    private String name;

    public Transmission() {
    }

    public Transmission(String name) {
        this.name = name;
    }

    public Transmission(long id) {
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
