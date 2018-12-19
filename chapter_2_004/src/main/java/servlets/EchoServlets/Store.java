package servlets.EchoServlets;

import java.util.List;

public interface Store {
    public void add(User user);
    public void update(User user);
    public void delete(User user);
    public List<User> findAll(User user);
    public User findById(User user);
    public List<User> getAll();
}
