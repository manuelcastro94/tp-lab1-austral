package org.studyroom.control.servlet;

import org.studyroom.model.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 30/04/2014
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class PostServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter(Constants.QUESTION_HIDDEN_ID_VALUE).contains("q=")) {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/postAnswer");
            rd.forward(req, resp);
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/postQuestion");
            rd.forward(req, resp);
        }
    }
}
