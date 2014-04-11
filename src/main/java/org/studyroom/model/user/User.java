package org.studyroom.model.user;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * org.studyroom.model.user.User: Federico F. Favale
 * Date: 04/04/2014
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USER", schema = "PUBLIC", catalog = "PUBLIC")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "PASSWORD")
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
        return "org.studyroom.model.user.User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
