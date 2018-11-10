package ru.job4j.threads.monitor;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UserStorage {
    private boolean add (User user) {
        return false;
    }

    private boolean update(User user) {
        return false;
    }

    private boolean delete(User user) {
        return false;
    }
}
