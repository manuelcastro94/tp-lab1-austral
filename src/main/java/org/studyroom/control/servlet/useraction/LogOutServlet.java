package org.studyroom.control.servlet.useraction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Manuel on 08/05/14.
 */
public class LogOutServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session= req.getSession();
        session.invalidate();
        RequestDispatcher rd = req.getRequestDispatcher(""); //The url where go after logout
        rd.forward(req,res);
    }
}
