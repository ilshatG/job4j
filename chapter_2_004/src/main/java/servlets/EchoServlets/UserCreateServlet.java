package servlets.EchoServlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserCreateServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        String action = req.getParameter("action");
        String id = req.getParameter("id");
                writer.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Title</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<p>Add new user or update:</p>"
                + "<p>id is " + id + "</p>"
                + "<form action ='" + req.getContextPath() + "/create' name='addUser' method='post'>"

                + "<label>Name:</label>"
                + "<input type='text' name='user' value='" + name + "'/><br><br>"
                + "<label>Login:</label>"
                + "<input type='text' name='login' value='" + login + "'/><br><br>"
                + "<label>email:</label>"
                + "<input type='text' name='email' value='" + email + "'/><br><br>"
                + "<label>date:</label>"
                + "<input type='text' name='createDate' value='" + createDate + "'/><br><br>"
                + "<input type='submit' name='action' value='" + action + (action.equals("update")?" id=" + id:"") + "'/>"
                + "&nbsp"
                + "<input type='submit' name='action' value='cancel'/>"

                + "</form>"
                + "\n"
        );
        req.setAttribute("id", id);
        writer.append("</body>\n"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/list");
        rd.forward(req, resp);
    }
}
