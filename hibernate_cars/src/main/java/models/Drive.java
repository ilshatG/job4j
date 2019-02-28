package models;

/**
 * Drive. Front, Rear
 */
public class Drive {
    private long id;
    private String name;

    public Drive() {
    }

    public Drive(long id) {
        this.id = id;
    }

    public Drive(String name) {
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
