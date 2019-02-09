package servlets.echoservlets;

public class TownCountry {
    private String country;
    private String town;

    public TownCountry(String country, String town) {
        this.country = country;
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

}