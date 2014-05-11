package org.studyroom.control.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Created with IntelliJ IDEA.
 * org.studyroom.model.entities.User: Federico F. Favale
 * Date: 04/04/2014
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {

    private static HibernateUtil ourInstance = new HibernateUtil();
    private final SessionFactory sessionFactory;
    private final Session guestSession;

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            guestSession = sessionFactory.openSession();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return ourInstance.sessionFactory;
    }

    public static Session getGuestSession() {
        return ourInstance.guestSession;
    }

}
