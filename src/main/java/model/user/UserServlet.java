package model.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 28/03/2014
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.sendRedirect("google.com");
//        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.encodeURL(Constants.LOGIN_FORM_ACTION);
        PrintWriter out = resp.getWriter();
        User user = new User(req.getParameter(Constants.LOGIN_USERNAME_FIELD), req.getParameter(Constants.LOGIN_PASSWORD_FIELD));
        out.println(req.getRemoteUser());
        out.println(req.getUserPrincipal());
        out.println(user);
//        resp.sendRedirect("secured/securedPage.jsp");
    }
}
