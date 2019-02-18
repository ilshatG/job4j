package config;

public class Model {
    private static volatile Model instance;
    private Model() {

    }
    public static synchronized Model getInstance() {
        Model result;
        if (instance == null) {
            result = new Model();
        } else {
            result = instance;
        }
        return result;
    }
}
