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
@WebServlet(name = "FilterByTagServlet", urlPatterns = {"/filterByTag"})
public class FilterByTagServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Long tagId = Long.parseLong(req.getQueryString().substring(req.getQueryString().lastIndexOf("t=") + 2));
        Tag tag = TagDao.getInstance().getTag(HibernateUtil.getGuestSession(), tagId);
        req.setAttribute("tag", tag);
        req.setAttribute("questionsByTag", tag.getQuestions());
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/home/filterquestionbytag.jsp");
        rd.forward(req, res);
    }
}
