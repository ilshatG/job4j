package config;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ToDo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class JSON extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Session session = ((SessionFactory) req.getServletContext().getAttribute("hibernateFactory")).openSession();
        java.util.List items = session.createQuery("From models.ToDo Order by id").list();
        mapper.writeValue(resp.getOutputStream(), items);
    }

}