package config;

import models.ToDo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Timestamp;

public class ContextListener implements ServletContextListener {
    private SessionFactory factory;
    private Session session;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
        ToDo toDo = new ToDo();
        toDo.setDescription("make purchases");
        toDo.setDone(false);
        toDo.setCreated(new Timestamp(System.currentTimeMillis()));
        session.save(toDo);
        toDo = new ToDo();
        toDo.setDescription("conquer the world");
        toDo.setDone(false);
        toDo.setCreated(new Timestamp(System.currentTimeMillis()));
        session.save(toDo);
        toDo = new ToDo();
        toDo.setDescription("fuck every woman in the ofiice");
        toDo.setDone(true);
        toDo.setCreated(new Timestamp(System.currentTimeMillis()));
        session.saveOrUpdate(toDo);
        session.getTransaction().commit();
        session.close();
        sce.getServletContext().setAttribute("hibernateFactory", factory);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        factory.close();
    }
}
