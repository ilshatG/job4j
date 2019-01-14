package servlets.EchoServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersController extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    private DispatchPattern dispatch = new DispatchPattern(logic);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        synchronized (session){
            if (session == null || session.getAttribute("user") == null) {
                resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
            } else {
                req.setAttribute("users", ValidateService.getInstance().getAll());
                req.getRequestDispatcher("WEB-INF/views/usersListView.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String id = "";
        String name = req.getParameter("user");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        String role = req.getParameter("role");
        String password = req.getParameter("password");
        User user = new User(0,name, login, email, createDate, role, password);
        if (action.contains("delete")) {
            id = action.substring(10);
            action="delete";
            user = new User(Integer.parseInt(id), "", "", "", "", "");
        }
        if (action.contains("update")) {
            id = action.substring(10);
            action = "update";
            if (role == null || role.equals("")) {
                role = "guest";
            }
            user = new User(Integer.parseInt(id), name, login, email, createDate, role, password);
        }

        if(action != null) {
            dispatch.doAction(action, user);
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
