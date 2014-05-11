package org.studyroom.control.servlet.useraction;

import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.utilities.HibernateUtil;
import org.studyroom.model.entities.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 08/05/2014
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "CloseQuestionServlet", urlPatterns = {"/close"})
public class CloseQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long questionID = Long.parseLong(req.getQueryString().replaceFirst("q=", ""));
        Question question = QuestionDao.getInstance().getQuestion(HibernateUtil.getGuestSession(), questionID);
        question.setClosed(true);
        QuestionDao.getInstance().addQuestion(HibernateUtil.getGuestSession(), question);
        resp.sendRedirect("/studyroom/goTo?goto&q=" + question.getId());
    }
}
