package model.user;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 19/03/14
 * Time: 08:51
 * To change this template use File | Settings | File Templates.
 */
public class UserBean {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public boolean valid;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String newUsername) {
        username = newUsername;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean newValid) {
        valid = newValid;
    }
}
