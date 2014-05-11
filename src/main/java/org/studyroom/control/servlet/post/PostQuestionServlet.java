package org.studyroom.control.servlet.post;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.PostChecker;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.model.Constants;
import org.studyroom.model.entity.Question;
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
 * Date: 16/04/2014
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "PostQuestionServlet", urlPatterns = {"/postQuestion"})
public class PostQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), req.getRemoteUser());
        String questionStr = req.getParameter(Constants.TEXT_AREA).concat(PostChecker.getMedia(req));
        String questionTitle = req.getParameter(Constants.TITLE_FIELD);
        Question question = QuestionDao.makeQuestion(user, questionTitle, questionStr, req.getParameter("tags").split(";"));
        QuestionDao.getInstance().addQuestion(HibernateUtil.getGuestSession(), question);
        resp.sendRedirect("/studyroom/index.jsp");
    }

}