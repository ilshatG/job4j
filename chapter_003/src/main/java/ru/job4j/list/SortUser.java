package ru.job4j.list;

import java.util.*;
import java.util.stream.Collectors;

public class SortUser {
    Set<User> sort(List<User> users) {
        return users.stream().collect(Collectors.toCollection(TreeSet<User>::new));
    }

    public List<User> sortNameLength(List<User> users) {
        return users.stream().sorted(new UserNameLengthSort()).collect(Collectors.toList());
    }

    public List<User> sortByAllFields(List<User> users) {
        return users.stream().sorted((o1, o2) -> {
            int comp = ((User) o1).getName().compareTo(((User) o2).getName());
            if (comp != 0) {
                return comp;
            }
            return ((User) o1).getAge().compareTo(((User) o2).getAge());
            }).collect(Collectors.toList());

    }
}

class UserNameLengthSort implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return (int) (o1.getName().length() - o2.getName().length());
    }
}