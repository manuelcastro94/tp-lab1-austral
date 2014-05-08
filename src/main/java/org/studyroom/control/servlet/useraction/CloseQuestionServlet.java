package org.studyroom.control.servlet.useraction;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.model.entity.Question;

import javax.servlet.ServletException;
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
public class CloseQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long questionID = Long.parseLong(req.getQueryString().replaceFirst("q=", ""));
        Question question = QuestionDao.getInstance().getQuestion(HibernateUtil.getGuestSession(), questionID);
        question.setClosed(true);
        QuestionDao.getInstance().addQuestion(HibernateUtil.getGuestSession(), question);
        resp.sendRedirect("/studyroom/index.jsp");
    }
}