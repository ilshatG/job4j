package servlets.echoservlets;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryStore implements Store {
    private static volatile MemoryStore instance;
    ConcurrentHashMap<Integer, User> items;

    private MemoryStore() {
        items = new ConcurrentHashMap();
        testData();
    }

    public static MemoryStore getInstance() {
        MemoryStore localInstance = instance;
        if (localInstance == null) {
            synchronized (MemoryStore.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new MemoryStore();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }

    @Override
    public void add(User user) {
        items.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        items.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        items.remove(user.getId());
    }

    @Override
    public List<User> findAll(User user) {
        List result = new CopyOnWriteArrayList();
        Iterator iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, User> pair = (Map.Entry) iterator.next();
            if (pair.getValue().getName().equals(user.getName())) {
                result.add(pair.getValue());
            }
        }
        return result;
    }

    @Override
    public User findById(User user) {
        return items.get(user.getId());
    }

    public List<User> getAll() {
        List result = new CopyOnWriteArrayList();
        Iterator iterator = items.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, User> pair = (Map.Entry) iterator.next();
                result.add(pair.getValue());
        }
        return result;
    }

    private void testData() {
        add(new User(1, "Ivanov", "ivashka11", "ivashka778@test@ru", "01/1/2019", "admin", "admin", "Россия", "Самара"));
        add(new User(2, "Petrashko", "petrashka421", "petrashka@test.com", "05/1/2019","admin", "admin", "Россия", "Самара"));
        add(new User(3, "Pjerow", "perov143", "perov@test.ru", "03/2/2019","admin", "guest", "Россия", "Самара"));
    }

    @Override
    public User currentUser(String login, String password) {
        return null;
    }
}
