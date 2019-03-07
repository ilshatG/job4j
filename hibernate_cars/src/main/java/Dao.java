import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.function.Function;

/**
 * Data Access Object
 */
public class Dao {
    private final static Dao instance = new Dao();
    private final static SessionFactory factory = initFactory();

    private static SessionFactory initFactory() {
        SessionFactory result = null;
        try {
            result = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
        return result;
    }

    public static Dao getInstance() {
        return instance;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            //tx.commit();
            if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
                tx.commit();
            }
            session.close();
        }
    }

    public <T> boolean add(T t) {
        return this.tx(
                session -> {
                    session.saveOrUpdate(t);
                    return true;
                }
        );
    }

    /**
     * Find id by name field.
     */
    public long getId(String name, String beanName) {
        return this.tx(
                session -> {
                    String queryString = String.format("SELECT b.id FROM %s b where b.name=:name", beanName);
                    Query query = session.createQuery(queryString);
                    query.setParameter("name", name);
                    return (Long)query.uniqueResult();
                }
        );
    }
}
