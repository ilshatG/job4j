package models;

import java.util.HashSet;
import java.util.Set;

/**
 * Vehicle model. Corolla, Camry, Prado etc.
 */
public class Model {
    private long id;
    private String name;
    private Set<Brand> brands = new HashSet<>(0);

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }



    public Model(String name) {
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
