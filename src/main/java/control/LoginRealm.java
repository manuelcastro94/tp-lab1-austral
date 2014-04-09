package control;


import model.Constants;
import model.user.User;
import org.hibernate.Session;
import org.securityfilter.realm.SimpleSecurityRealmBase;

/**
 * Trivial implementation of the SecurityRealmInterface.
 * <p/>
 * There is one user: username is 'username', password is 'password'
 * And this user is in one role: 'inthisrole'
 *
 * @author Max Cooper (max@maxcooper.com)
 * @version $Revision: 1.3 $ $Date: 2003/10/25 10:49:04 $
 */
public class LoginRealm extends SimpleSecurityRealmBase {

    private String exampleProperty;

    /**
     * Authenticate a user.
     * <p/>
     * Implement this method in a subclass to avoid dealing with Principal objects.
     *
     * @param username a username
     * @param password a plain text password, as entered by the user
     * @return null if the user cannot be authenticated, otherwise a Principal object is returned
     */
    public boolean booleanAuthenticate(String username, String password) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User o = (User) session.get(User.class, username);


        return o.getPassword().equals(password);
    }


    /**
     * Test for role membership.
     * <p/>
     * Implement this method in a subclass to avoid dealing with Principal objects.
     *
     * @param username The name of the user
     * @param role     name of a role to test for membership
     * @return true if the user is in the role, false otherwise
     */
    public boolean isUserInRole(String username, String role) {
        return (
                (Constants.VALID_USERNAME.equals(username) || Constants.VALID_USERNAME2.equals(username))
                        && Constants.VALID_ROLE.equals(role)
        );
    }

    /**
     * Getter for exampleProperty.
     *
     * @return the value of exampleProperty
     */
    public String getExampleProperty() {
        return exampleProperty;
    }

    /**
     * Setter for exampleProperty to deomonstrate setting realm properties from config file.
     * <p/>
     * This has no effect other than printing a message when the property is set.
     *
     * @param value example property value
     */
    public void setExampleProperty(String value) {
        exampleProperty = value;
        System.out.println(this.getClass().getName() + ": exampleProperty set to \'" + value + "\'");
    }
}

