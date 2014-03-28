package model.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/Federico/SkyDrive/Documentos/Programacion/Lab1/lib/studyroom");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PUBLIC.USER");
//            ps.setString(1,"AAAAA");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                out.println(rs.getString(1));
                out.println(rs.getString(2));
//                System.out.println(rs.getString(1));
            }

//            while (rs.next()){
//                out.println(rsmd.getColumnName(1));
//                out.println(rs.getString(1));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        User user = new User(req.getParameter(Constants.LOGIN_USERNAME_FIELD), req.getParameter(Constants.LOGIN_PASSWORD_FIELD));
//        PrintWriter out = resp.getWriter();
//        out.println(user);
    }
}
