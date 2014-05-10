package org.studyroom.control.servlet.post;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.PostChecker;
import org.studyroom.control.dao.AnswerDao;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.model.Constants;
import org.studyroom.model.entity.Answer;
import org.studyroom.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "PostAnswerServlet", urlPatterns = {"/postAnswer"})
public class PostAnswerServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long questionId = Long.parseLong(req.getParameter(Constants.QUESTION_HIDDEN_ID_VALUE).replaceFirst("q=", ""));
        User user = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), req.getRemoteUser());
        Answer answer = new Answer(QuestionDao.getInstance().getQuestion(HibernateUtil.getGuestSession(), questionId),
                req.getParameter(Constants.TEXT_AREA).concat(PostChecker.getMedia(req)), user
        );
        AnswerDao.getInstance().addAnswer(HibernateUtil.getGuestSession(), answer);
        resp.sendRedirect("/studyroom/goTo?goto&q=" + questionId);
    }

}
