package org.studyroom.control.servlet.post;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.PostChecker;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.model.Constants;
import org.studyroom.model.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 07/05/2014
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 */
public class EditQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long questionID = Long.parseLong(req.getParameter(Constants.QUESTION_HIDDEN_ID_VALUE).replaceFirst("edit&q=", ""));
        String input = req.getParameter(Constants.TEXT_AREA).concat(PostChecker.getMedia(req));
        Question question = QuestionDao.getInstance().getQuestion(HibernateUtil.getGuestSession(), questionID);
        question.setQuestion(input);
        QuestionDao.getInstance().addQuestion(HibernateUtil.getGuestSession(), question);
        resp.sendRedirect("/studyroom/index.jsp");
    }

}
