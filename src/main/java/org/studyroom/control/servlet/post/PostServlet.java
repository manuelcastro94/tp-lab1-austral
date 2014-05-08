package org.studyroom.control.servlet.post;

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
        String hiddenValue = req.getParameter(Constants.QUESTION_HIDDEN_ID_VALUE);
        ServletContext context = getServletContext();
        RequestDispatcher rd;
        if (hiddenValue.contains("ask")) {
            rd = context.getRequestDispatcher("/postQuestion");
        } else if (hiddenValue.contains("edit&q=")) {
            rd = context.getRequestDispatcher("/editQuestion");
        } else {
            rd = context.getRequestDispatcher("/postAnswer");
        }
        rd.forward(req, resp);
    }
}
