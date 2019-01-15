package servlets.echoservlets;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateStub implements Store {
    private final Map<Integer, User> store = new HashMap<>();
    private int ids = 0;

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll(User user) {
        return null;
    }

    @Override
    public User findById(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(this.store.values());
    }

    @Override
    public User currentUser(String login, String password) {
        return null;
    }

    @Override
    public void add(User user) {
        user.setId(this.ids++);
        this.store.put(user.getId(), user);
        return;
    }
}
