package org.studyroom.control.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.studyroom.model.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 11/04/2014
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class UserDAO extends DataAO {

    private static UserDAO ourInstance = new UserDAO();

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        return ourInstance;
    }


    public User getUser(Session session, String user) {
        super.beginTransaction(session);
        Query query = session.createQuery("select user from User user where user.email= :yourUser");
        query.setParameter("yourUser", user);
        super.endTransaction(session);
        return (User) query.uniqueResult();
    }

    public void addUser(Session session, User user) {
        super.beginTransaction(session);
        session.save(user);
        super.endTransaction(session);
    }
}
