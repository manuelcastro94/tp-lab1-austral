package model.user;

import model.Connection;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * model.user.User: Federico F. Favale
 * Date: 04/04/2014
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USER", schema = "PUBLIC", catalog = "PUBLIC")
public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public static boolean exist(User user) {
        ResultSet dataBase = Connection.getDataBase();
        try {
            while (dataBase.next()) {
                if (user.equals(new User(dataBase.getString(1), dataBase.getString(2)))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Id
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "model.user.User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
