package model.user;

import model.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 28/03/2014
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("AAAAAAAAAAAAAAA");
        model.Connection.setUser(new User(req.getParameter(Constants.LOGIN_USERNAME_FIELD), req.getParameter(Constants.LOGIN_PASSWORD_FIELD)));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WWWWWWWWWWWW");
        super.doGet(req, resp);
    }


    // from ex UserServlet
    ////        resp.encodeURL(Constants.LOGIN_FORM_ACTION);
////        PrintWriter out = resp.getWriter();
////        User user = new User(req.getParameter(Constants.LOGIN_USERNAME_FIELD), req.getParameter(Constants.LOGIN_PASSWORD_FIELD));
////        out.println(req.getRemoteUser());
////        out.println(req.getUserPrincipal());
////        out.println(user);
////        resp.sendRedirect("secured/securedPage.jsp");
//
//        String target = req.getParameter("targetPage");
//        String user = req.getParameter("j_username");
//        String pass = req.getParameter("j_password");
//        String redirectUrl = "/index.jsp";
//
////        req.getSession().setAttribute("redirectUrl", redirectUrl);
////        resp.addHeader("Refresh", "5");
//        resp.sendRedirect("j_security_check?j_username="+user+"&j_password="+pass);
}
