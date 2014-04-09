package model;

import control.HibernateUtil;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * model.user.User: Federico F. Favale
 * Date: 01/04/2014
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        try {
            //
        } finally {
            session.close();
        }
    }
}
