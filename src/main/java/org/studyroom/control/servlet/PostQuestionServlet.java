package org.studyroom.control.servlet;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.model.question.Question;
import org.studyroom.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 16/04/2014
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class PostQuestionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), req.getRemoteUser());
        Question question = new Question(req.getParameter("editable1"), user);
        QuestionDao.getInstance().addQuestion(HibernateUtil.getGuestSession(), question);
        resp.sendRedirect("/studyroom/index.jsp");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req,resp);
    }
}