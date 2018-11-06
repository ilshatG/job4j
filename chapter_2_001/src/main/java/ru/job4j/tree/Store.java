package ru.job4j.tree;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Store {
    Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        Map<Integer, String> initial = new TreeMap<>();
        for (User user : previous) {
            initial.put(user.id, user.name);
        }
        for (User user : current) {
            String previousName = initial.get(user.id);
            if (previousName != null) {
                if (!previousName.equals(user.name)) {
                    result.setChanged(result.getChanged() + 1);
                }
            } else {
                result.setAdded(result.getAdded() + 1);
            }
        }
        result.setDeleted(previous.size() - current.size() + result.getAdded());
        return result;
    }

    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}

class Info {
    private int added = 0;
    private int changed = 0;
    private int deleted = 0;

    public Info() {
    }

    public Info(int added, int changed, int deleted) {
        this.added = added;
        this.changed = changed;
        this.deleted = deleted;
    }

    public int getAdded() {
        return added;
    }

    public int getChanged() {
        return changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Info info = (Info) o;
        return added == info.added
                && changed == info.changed
                && deleted == info.deleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(added, changed, deleted);
    }
}