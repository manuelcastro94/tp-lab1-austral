package model.user;

import java.io.Serializable;

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


    //TODO: hacer que este metodo se fije de alguna forma si el usuario existe en la base de datos
    public static boolean valid(User user) {
        return Math.random() > 0.5;
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
