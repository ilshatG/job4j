package config;

import models.ToDo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ToDo toDo = new ToDo(
        req.getParameter("id"),
        req.getParameter("description"),
        req.getParameter("created"),
        req.getParameter("done")
        );

        Session session = ((SessionFactory) req.getServletContext().getAttribute("hibernateFactory")).openSession();
        session.beginTransaction();
        if (toDo.getId() != 0) {
            ToDo foundTodo;
            foundTodo = session.get(ToDo.class, toDo.getId());
            foundTodo.setDone(toDo.isDone());
            toDo = foundTodo;
        }

        session.saveOrUpdate(toDo);
        session.getTransaction().commit();

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/JSON");
        dispatcher.forward(req, resp);
    }
}
