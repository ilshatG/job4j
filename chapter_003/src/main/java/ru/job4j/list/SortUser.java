package ru.job4j.list;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    Set<User> sort(List<User> users) {
        Set result = new TreeSet<User>();
        result.addAll(users);
        return result;
    }
}
