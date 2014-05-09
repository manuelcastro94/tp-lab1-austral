package org.studyroom.control.servlet.load;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 02/05/2014
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "LoginErrorServlet", urlPatterns = {"/loginerror"})
public class LoginErrorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/studyroom/index.jsp?loginError");
    }
}
