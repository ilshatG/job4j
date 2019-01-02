package servlets.EchoServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersController extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    private DispatchPattern dispatch = new DispatchPattern(logic);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", logic.getAll());
        req.getRequestDispatcher("/WEB-INF/views/usersListView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String id = "";
        String name = req.getParameter("user");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        User user = new User(name, login, email, createDate);;
        if (action.contains("delete")) {
            id = action.substring(10);
            action="delete";
            user = new User(Integer.parseInt(id), "", "", "", "");
        }
        if (action.contains("update")) {
            id = action.substring(10);
            action="update";
            user = new User(Integer.parseInt(id), name, login, email, createDate);
        }

        if(action != null) {
            dispatch.doAction(action, user);
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
