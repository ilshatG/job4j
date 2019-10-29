import models.Ad;
import models.User;

import java.util.List;

public interface Store {
    <T> boolean add(T t);
    //void add(Ad item);
    void update(Ad item);
    void delete(Ad item);
    List<User> getAll();
    User currentUser(String login, String password);
    List getListFromSQL(String query);
}
