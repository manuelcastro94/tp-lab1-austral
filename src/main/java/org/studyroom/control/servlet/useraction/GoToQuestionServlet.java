package org.studyroom.control.servlet.useraction;

import org.studyroom.control.dao.QuestionDao;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.control.utilities.HibernateUtil;
import org.studyroom.model.entities.Question;
import org.studyroom.model.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 09/05/2014
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "GoToQuestionServlet", urlPatterns = {"/goTo"})
public class GoToQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long questionID = Long.parseLong(req.getQueryString().substring(req.getQueryString().lastIndexOf("q=") + 2));
        Question question = QuestionDao.getInstance().getQuestion(HibernateUtil.getGuestSession(), questionID);
        User thisUser = UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), req.getRemoteUser());
        req.setAttribute("question", question);
        req.setAttribute("user", thisUser);
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/home/subpages/fullquestionview.jsp");
        rd.forward(req, resp);
    }
}
