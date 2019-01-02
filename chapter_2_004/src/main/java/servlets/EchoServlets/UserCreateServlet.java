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
        /*resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String name = antiNull(req.getParameter("name"));
                writer.append("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "\n"
        );
                req.setAttribute("id", id);
        writer.append("</body>\n"
                + "</html>");
        writer.flush();
        */
        req.getRequestDispatcher("/WEB-INF/views/createView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/");
        rd.forward(req, resp);
    }
}
