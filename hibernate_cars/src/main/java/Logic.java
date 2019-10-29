import models.*;

import java.sql.Timestamp;
import java.util.List;

public class Logic implements Store {
    private static final Logic instance = new Logic();
    private final Dao store = Dao.getInstance();
    {addData();}

    private Logic() {
    }

    public static Logic getInstance() {
        return instance;
    }

    @Override
    public <T> boolean add(T t) {
        store.add(t);
        return true;
    }

    @Override
    public void update(Ad item) {

    }

    @Override
    public void delete(Ad item) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User currentUser(String login, String password) {
        return null;
    }

    @Override
    public List getListFromSQL(String query) {
        return store.getListFromSQL(query);
    }

    private void addData() {
        Brand toyota = new Brand("Toyota");
        toyota.getModels().add(new Model("Corolla"));
        toyota.getModels().add(new Model("Camry"));
        toyota.getModels().add(new Model("RAV-4"));
        store.add(toyota);

        store.add(new Wheel("left"));
        store.add(new Wheel("right"));

        store.add(new Drive("front"));
        store.add(new Drive("rear"));
        store.add(new Drive("4WD"));

        store.add(new Colour("white"));
        store.add(new Colour("black"));
        store.add(new Colour("red"));
        store.add(new Colour("silver"));

        store.add(new CarBody("hatchback"));
        store.add(new CarBody("sedan"));
        store.add(new CarBody("estate"));

        store.add(new EngineType("gasoline"));
        store.add(new EngineType("diesel"));

        store.add(new Transmission("automatic"));
        store.add(new Transmission("manual"));
        store.add(new Transmission("variator"));

        Role adminRole = new Role("administraror");
        Role userRole = new Role("user");
        store.add(adminRole);
        store.add(userRole);

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

        store.add(adminUser);
        store.add(plainUser);

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

        store.add(ad);
    }
}
