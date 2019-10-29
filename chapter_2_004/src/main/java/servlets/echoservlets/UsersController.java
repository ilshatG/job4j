package servlets.echoservlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UsersController extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    private final DispatchPattern dispatch = new DispatchPattern(logic);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        synchronized (session) {
            if (session == null || session.getAttribute("user") == null) {
                resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
            } else {
                req.setAttribute("users", ValidateService.getInstance().getAll());
                req.getRequestDispatcher("WEB-INF/views/usersListView.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");

        User user = new User(
                    tryParseInt(req.getParameter("id")),
                    req.getParameter("name"),
                    req.getParameter("login"),
                    req.getParameter("email"),
                    req.getParameter("createDate"),
                    req.getParameter("role"),
                    req.getParameter("password"),
                    req.getParameter("country"),
                    req.getParameter("town")
                );

        DispathParams dispParams = new DispathParams(user, req, resp,null);


        dispatch.doAction(action, dispParams);

        resp.setHeader("Refresh", "5");

        try {
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (IOException e) {

        }
    }

    int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch(NumberFormatException nfe) {
            return 0;
        }
    }
}