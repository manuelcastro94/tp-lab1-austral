package org.studyroom.control.servlet;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.AnswerDao;
import org.studyroom.model.entity.Question;
import org.studyroom.model.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 22/04/2014
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public class LoadAnswerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("answer", AnswerDao.getInstance().getAnswers(HibernateUtil.getGuestSession(), new Question("dsdfsdfds", new User("fede", "fede"))));
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/home/home.jsp");
        rd.forward(req, resp);
    }

}
