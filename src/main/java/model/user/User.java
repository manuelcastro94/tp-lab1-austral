package model.user;

import model.Connection;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 18/03/14
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {

    //    private String userName;
    private String email;
    private String password;

    public User(/*String userName,*/ String email, String password) {
//        this.userName = userName;
        this.email = email;
        this.password = password;
    }

//    public String getUserName() {
//        return userName;
//    }

//    public void setUserName(String userName) {                         user
//        this.userName = userName;
//    }

    public static boolean exist(User user) {
        ResultSet dataBase = Connection.getDataBase();
        try {
            while (dataBase.next()) {
                if (user.isTheSame(new User(dataBase.getString(1), dataBase.getString(2)))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean isTheSame(User user) {
        return this.getEMail().equals(user.getEMail()) && this.getPassword().equals(user.getPassword());
    }

    public String getEMail() {
        return email;
    }

    public void setEMail(String eMail) {
        this.email = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
