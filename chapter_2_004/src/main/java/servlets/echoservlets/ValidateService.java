package servlets.echoservlets;

import java.util.List;

//Logic Layout
public class ValidateService implements Store {
    private static volatile ValidateService instance;
    private final Store persistence = DBStore.getInstance();    //MemoryStore.getInstance();

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
        if (validateUser(user)) {
            persistence.add(user);
        }
    }

    public void update(User user) {
        if (validateUser(user)) {
            persistence.update(user);
        }
    }

    public void delete(User user) {
        persistence.delete(user);
    }

    @Override
    public List<User> findAll(User user) {
        return null;
    }

    @Override
    public User findById(User user) {
        return null;
    }

    public List<User> getAll() {
        return persistence.getAll();
    }

    @Override
    public User currentUser(String login, String password) {
        return persistence.currentUser(login, password);
    }

    private boolean validateUser(User user) {
        if (user.getName().equals("") || user.getEmail().equals("") || user.getLogin().equals("")
                || user.getCreateDate().equals("")) {
            return false;
        }
        List<User> users = getAll();
        for (User record:users) {
            if (record.getId() != user.getId()) {
                if ((record.getEmail().equals(user.getEmail()) || record.getLogin().equals(user.getLogin()))) {
                    return false;
                }
            }
        }
        return true;
    }
}
