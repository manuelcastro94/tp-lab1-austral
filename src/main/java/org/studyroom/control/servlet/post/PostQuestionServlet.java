package org.studyroom.control.servlet.post;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.PostChecker;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.dao.TagDao;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.model.Constants;
import org.studyroom.model.entity.Question;
import org.studyroom.model.entity.Tag;
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
        String input = req.getParameter(Constants.TEXT_AREA).concat(PostChecker.getMedia(req));
        Question question = new Question(req.getParameter(Constants.TITLE_FIELD), input, user);
        String[] strTags = req.getParameter("tags").split(";");
        for (String strTag : strTags) {
            Tag tag = new Tag(strTag);
            if (TagDao.getInstance().getTag(HibernateUtil.getGuestSession(), tag.getTag()) == null) {
                question.addTags(tag);
                TagDao.getInstance().addTag(HibernateUtil.getGuestSession(), tag);
            } else {
                question.addTags(TagDao.getInstance().getTag(HibernateUtil.getGuestSession(), tag.getTag()));
            }

        }
        QuestionDao.getInstance().addQuestion(HibernateUtil.getGuestSession(), question);
        resp.sendRedirect("/studyroom/index.jsp");
    }

}