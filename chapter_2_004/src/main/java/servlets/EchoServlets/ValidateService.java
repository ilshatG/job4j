package servlets.EchoServlets;

import java.util.List;

//Logic Layout
public class ValidateService {
    private static volatile ValidateService instance;
    private final Store persistence = MemoryStore.getInstance();

    private ValidateService() {

    }

    public static synchronized ValidateService getInstance() {
        ValidateService result;
        if (instance == null) {
            result = new ValidateService();
        } else {
            result = instance;
        }
        return result;
    }

    public void add(User user) {
        persistence.add(user);
    }

    public void update(User user) {
        persistence.add(user);
    }

    public void delete(User user) {
        persistence.delete(user);
    }

    public List<User> getAll() {
        return persistence.getAll();
    }
}
