package servlets.echoservlets;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DispatchPattern {
    private final Map<String, Function<DispathParams, Boolean>> dispatch = new HashMap<>();
    private ValidateService logic;

    DispatchPattern(ValidateService logic) {
        this.logic = logic;
        init();
    }

    public Function<DispathParams, Boolean> addUser() {
        return dispParam -> {
            logic.add(dispParam.getUser());
            return true;
        };
    }

    public Function<DispathParams, Boolean> deleteUser() {
        return dispParam -> {
            logic.delete(dispParam.getUser());
            return true;
        };
    }

    public Function<DispathParams, Boolean> updateUser() {
        return dispParam -> {
            logic.update(dispParam.getUser());
            return true;
        };
    }

    public Function<DispathParams, Boolean> showUserEditForm() {
        return  dispParam -> {
            try {
                dispParam.getReq().getRequestDispatcher("/WEB-INF/views/createView.jsp").forward(dispParam.getReq(), dispParam.getResp());
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    public Function<DispathParams, Boolean> doNothing() {
        return user -> {
            return false;
        };
    }

    public DispatchPattern init() {
        this.load("add", this.addUser());
        this.load("delete", this.deleteUser());
        this.load("update", this.updateUser());
        this.load("edit", this.showUserEditForm());
        this.load("cancel", this.doNothing());
        this.load(null, this.doNothing());
        return this;
    }

    private void load(String type, Function<DispathParams, Boolean> handle) {
        this.dispatch.put(type, handle);
    }

    public boolean doAction(final String action, final DispathParams dispParams) {
        return this.dispatch.get(
                action
        ).apply(dispParams);
    }
}
