import models.*;

import java.sql.Timestamp;

public class ConsoleApp {

    public static void main(String[] args) {
        Dao dao = Dao.getInstance();

        Brand toyota = new Brand("Toyota");
        toyota.getModels().add(new Model("Corolla"));
        toyota.getModels().add(new Model("Camry"));
        toyota.getModels().add(new Model("RAV-4"));
        dao.add(toyota);

        dao.add(new Wheel("left"));
        dao.add(new Wheel("right"));

        dao.add(new Drive("front"));
        dao.add(new Drive("rear"));
        dao.add(new Drive("4WD"));

        dao.add(new Colour("white"));
        dao.add(new Colour("black"));
        dao.add(new Colour("red"));
        dao.add(new Colour("silver"));

        dao.add(new CarBody("hatchback"));
        dao.add(new CarBody("sedan"));
        dao.add(new CarBody("estate"));

        dao.add(new EngineType("gasoline"));
        dao.add(new EngineType("diesel"));

        dao.add(new Transmission("automatic"));
        dao.add(new Transmission("manual"));
        dao.add(new Transmission("variator"));

        Role adminRole = new Role("administraror");
        Role userRole = new Role("user");
        dao.add(adminRole);
        dao.add(userRole);

        User adminUser = new User("Abraham",
                "Lincoln",
                "+7-9058-44-83-00",
                "admin",
                "admin",
                "Philadelphia",
                new Timestamp(System.currentTimeMillis()),
                adminRole);

        User plainUser = new User("Benjamin",
                "Franklin",
                "+7-9058-44-83-02",
                "user",
                "user",
                "Philadelphia",
                new Timestamp(System.currentTimeMillis()),
                userRole);

        dao.add(adminUser);
        dao.add(plainUser);

        Ad ad = new Ad();
        ad.setBrandModel(new BrandModel(1,1));
        ad.setWheel(new Wheel(1));
        ad.setDrive(new Drive(1));
        ad.setColour(new Colour(1));
        ad.setCarBody(new CarBody(1));
        ad.setEngineType(new EngineType(1));
        ad.setTransmission(new Transmission(1));
        ad.setUser(plainUser);
        ad.setOwners(1);
        ad.setEngineVolume(2500);
        ad.setCarMeleage(80_000);
        ad.setYear(2015);
        ad.setPowerOfEngine(230);
        ad.setDescription("Excellent car.");
        ad.setPublished(new Timestamp(System.currentTimeMillis()));
        ad.setPrice(100_000.0);
        ad.setSale(false);

        dao.add(ad);
    }
}

