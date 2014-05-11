package org.studyroom.control.servlet.post;

import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.utilities.Converter;
import org.studyroom.control.utilities.HibernateUtil;
import org.studyroom.model.Constants;
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
 * Date: 07/05/2014
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "EditQuestionServlet", urlPatterns = {"/editQuestion"})
public class EditQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long questionID = Long.parseLong(req.getParameter(Constants.QUESTION_HIDDEN_ID_VALUE).replaceFirst("edit&q=", ""));
        String questionStr = req.getParameter(Constants.TEXT_AREA).concat(Converter.getMedia(req));
        String questionTitle = req.getParameter(Constants.TITLE_FIELD);
        Question question = QuestionDao.getInstance().getQuestion(HibernateUtil.getGuestSession(), questionID);
        question = QuestionDao.editQuestion(question, question.getUser(), questionTitle, questionStr, req.getParameter("tags").split(";"));
        QuestionDao.getInstance().addQuestion(HibernateUtil.getGuestSession(), question);
        resp.sendRedirect("/studyroom/goTo?goto&q=" + questionID);
    }

}
