package org.studyroom.control.servlet;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.AnswerDao;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.model.Constants;
import org.studyroom.model.answer.Answer;
import org.studyroom.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 22/04/2014
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
public class PostAnswerServlet extends HttpServlet {

    //TODO hacer esto como la gente
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), req.getRemoteUser());
        Answer answer = new Answer(QuestionDao.getInstance().getQuestionById(HibernateUtil.getGuestSession(), Long.parseLong(req.getParameter(Constants.QUESTION_ID))),
                req.getParameter(Constants.ANSWER_FIELD), user);
        AnswerDao.getInstance().addAnswer(HibernateUtil.getGuestSession(), answer);
        resp.sendRedirect("/studyroom/index.jsp");
    }

}
