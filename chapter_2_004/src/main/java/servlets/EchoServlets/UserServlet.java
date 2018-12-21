package servlets.EchoServlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    private DispatchPattern dispatch = new DispatchPattern(logic);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //должен отдавать всех пользователей в системе
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<User> items = logic.getAll();
        writer.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Title</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<p>This is a user list:</p>"
                + "\n"
        );

        int counter = 1;
        for (User user: items) {
            writer.append("<b>" + counter++ + ". </b>" + "<b>id:</b> " + user.getId() + "\t <b>name: </b>" + user.getName() + "\t <b>login: </b>" + user.getLogin()
                    + "\t <b>email: </b>" + user.getEmail() + "<br>\n\r");
        }
        writer.append("</body>\n"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //create user, update user, remove user
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        String user = req.getParameter("user");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String createDate = req.getParameter("createDate");
        dispatch.doAction(action, new User(Integer.parseInt(id), user, login, email, createDate));
        doGet(req, resp);
    }
}
