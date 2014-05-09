package org.studyroom.control.servlet.useraction;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.AnswerDao;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.model.entity.Answer;
import org.studyroom.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 08/05/2014
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class VoteDownServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long answerID = Long.parseLong(req.getQueryString().replaceFirst("a=", ""));
        User user = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), req.getRemoteUser());
        Answer answer = AnswerDao.getInstance().getAnswer(HibernateUtil.getGuestSession(), answerID);
        if (!answer.hasVoted(user)) {
            answer.voteDown(user);
            AnswerDao.getInstance().addAnswer(HibernateUtil.getGuestSession(), answer);
        }
        resp.sendRedirect("/studyroom/index.jsp");
    }
}
