package models;

/**
 * Car body. Кузов автомобиля
 */
public class CarBody {
    private long id;
    private String name;

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

    public CarBody() {
    }

    public CarBody(long id) {
        this.id = id;
    }

    public CarBody(String name) {
        this.name = name;
    }
}
