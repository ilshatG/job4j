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
        //оставлю на потом для примера, когда позабуду, как делается
        /*resp.setContentType("text/html");
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
                + "<table border = '1'><th>N</th> <th>Id</th>"
                + "<th>Name</th> <th>login</th> <th>e-mail</th> <th>action</th>"
        );

        int counter = 1;
        for (User user: items) {
            writer.append("<tr><td>" + counter++ + ". </td>" + "<td>" + user.getId() + "</td> <td>" + user.getName() + "</td> <td>" + user.getLogin()
                    + "</td><td>" + user.getEmail() + "</td> <td>"
                    + "<form action ='"+ req.getContextPath() +"/list' name ='form' method='post'> "
                    + "<input type = 'submit' name ='action'"  + " value = 'delete id=" + user.getId() + "'/>"
                    + "<a href = '"+ req.getContextPath()+"/create?name=" + user.getName() + "&login=" + user.getLogin()
                    + "&email=" + user.getEmail()
                    + "&createDate=" + user.getCreateDate()
                    + "&id=" + user.getId()
                    + "&action=update"
                    + "'> <input type = 'button' name ='action'"  + " value='edit'/></a>"
                    + "</form> "
                    + "</td>"
                    + "</tr>\n\r");
        }
        writer.append("</table><br>\n");
        writer.append("<a href='/UserServlet/create?name=&login=&email=&createDate=&action=add'/>Add new user</a>\n");
        writer.append("</body>\n"
                + "</html>");
        writer.flush();*/
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
        //doGet(req, resp);
        resp.sendRedirect("index.jsp");
    }
}
