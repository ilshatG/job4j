package ru.job4j.list;

import java.util.*;

public class SortUser {
    Set<User> sort(List<User> users) {
        Set result = new TreeSet<User>();
        result.addAll(users);
        return result;
    }

    public List<User> sortNameLength(List<User> users) {
        Comparator<User> lengthSort = new UserNameLengthSort();
        Collections.sort(users, lengthSort);
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Collections.sort(users, new Comparator() {
            public int compare(Object o1, Object o2) {
                int comp = ((User) o1).getName().compareTo(((User) o2).getName());
                if (comp != 0) {
                    return comp;
                }
                return ((User) o1).getAge().compareTo(((User) o2).getAge());
            } });
        return users;
    }
}

class UserNameLengthSort implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return (int) (o1.getName().length() - o2.getName().length());
    }
}