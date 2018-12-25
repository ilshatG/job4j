package servlets.EchoServlets;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatchPattern {
    private final Map<String, Function<User, Boolean>> dispatch = new HashMap<>();
    private ValidateService logic;

    DispatchPattern(ValidateService logic) {
        this.logic = logic;
        init();
    }

    public Function<User, Boolean> addUser() {
        return user -> {
            logic.add(user);
            return true;
        };
    }

    public Function<User, Boolean> deleteUser() {
        return user -> {
            logic.delete(user);
            return true;
        };
    }

    public Function<User, Boolean> updateUser() {
        return user -> {
            logic.update(user);
            return true;
        };
    }

    public Function<User, Boolean> doNothing() {
        return user -> {
            return false;
        };
    }

    public DispatchPattern init() {
        this.load("add", this.addUser());
        this.load("delete", this.deleteUser());
        this.load("update", this.updateUser());
        this.load("cancel", this.doNothing());
        return this;
    }

    private void load(String type, Function<User, Boolean> handle) {
        this.dispatch.put(type, handle);
    }

    public boolean doAction(final String action, final User user) {
        return this.dispatch.get(
                action
        ).apply(user);
    }
}
