package org.studyroom.control.servlet.useraction;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.TagDao;
import org.studyroom.model.entity.Tag;

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
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "SearchByTagServlet", urlPatterns = {"/searchByTag"})
public class SearchByTagServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Long tagId = Long.parseLong(req.getQueryString().replaceFirst("t=", ""));
        Tag tag = TagDao.getInstance().getTag(HibernateUtil.getGuestSession(), tagId);
        req.setAttribute("questionsByTag", tag.getQuestions());
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/home/userload.jsp");
        rd.forward(req, res);
    }
}
