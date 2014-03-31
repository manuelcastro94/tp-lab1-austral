package model;

import java.io.PrintWriter;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 28/03/2014
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class Connection {

    private Connection() {
    }

    public static ResultSet getDataBase() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println(Thread.currentThread().getContextClassLoader().getResource("").toString().replaceAll("out/artifacts/Lab1_war_exploded/WEB-INF/classes/","lib/studyroom").substring(6));
            java.sql.Connection con = DriverManager.getConnection("jdbc:hsqldb:" + Thread.currentThread().getContextClassLoader().getResource("").toString().replaceAll("out/artifacts/Lab1_war_exploded/WEB-INF/classes/", "lib/studyroom").substring(6));
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PUBLIC.USER");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

//    PrintWriter out = resp.getWriter();
//    try {
//        Class.forName("org.hsqldb.jdbc.JDBCDriver");
//        java.sql.Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/Federico/SkyDrive/Documentos/Programacion/Lab1/lib/studyroom");
//        PreparedStatement ps = con.prepareStatement("SELECT * FROM PUBLIC.USER");
////            ps.setString(1,"AAAAA");
//        ResultSet rs = ps.executeQuery();
//        ResultSetMetaData rsmd = rs.getMetaData();
//
//        while (rs.next()) {
//            out.println(rs.getString(1));
//            out.println(rs.getString(2));
////                System.out.println(rs.getString(1));
//        }
//
////            while (rs.next()){
////                out.println(rsmd.getColumnName(1));
////                out.println(rs.getString(1));
////            }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    }
//
////        PrintWriter out = resp.getWriter();
//        out.println(user);
}
