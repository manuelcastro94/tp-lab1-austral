package org.studyroom.control.servlet;

import org.studyroom.control.HibernateUtil;
import org.studyroom.control.dao.UserDAO;
import org.studyroom.model.Constants;
import org.studyroom.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * org.studyroom.model.entity.User: Federico F. Favale
 * Date: 28/03/2014
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User newUser = new User(req.getParameter(Constants.REGISTER_USERNAME_FIELD), req.getParameter(Constants.REGISTER_PASSWORD_FIELD));
        if (!UserDAO.getInstance().exists(HibernateUtil.getGuestSession(), newUser.getEmail())) {
            UserDAO.getInstance().addUser(HibernateUtil.getGuestSession(), newUser);
            resp.sendRedirect("/studyroom/index.jsp");
        } else {
            resp.sendRedirect("/studyroom/register/registerpage.jsp?noavailable");
        }


    }

}
