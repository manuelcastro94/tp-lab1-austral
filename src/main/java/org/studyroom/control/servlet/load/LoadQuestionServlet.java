package org.studyroom.control.servlet.load;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.QuestionDao;
import org.studyroom.model.entity.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 16/04/2014
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "LoadQuestionServlet", urlPatterns = {"/index.jsp"})
public class LoadQuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Question> questions = QuestionDao.getInstance().getQuestions(HibernateUtil.getGuestSession());
        req.setAttribute("questions", questions);
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/home/home.jsp");
        rd.forward(req, resp);
    }

}
