package org.studyroom.servlet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.studyroom.control.HibernateUtil;
import org.studyroom.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * org.studyroom.model.user.User: Federico F. Favale
 * Date: 28/03/2014
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("AAAAAAAAAAAAAAA");
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User newUser = new User("khb", "xf");
        session.save(newUser);
        transaction.commit();

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WWWWWWWWWWWW");
        super.doGet(req, resp);
    }
}
