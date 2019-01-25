package servlets.echoservlets;

public class Person {
    private String name;
    private String surname;
    private String pol;
    private String desc;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPol() {
        return pol;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
