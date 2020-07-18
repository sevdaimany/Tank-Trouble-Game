




/**
 * This class holds some fields about person identity
 * 
 * 
 *
 * @author Mohammad Mahdi MalMasi
 * @author Sevda Imany
 *
 * @version 0.0.2
 */
public class Identity
{
            /*  Fields  */

    // person name
    private String name;
    private String lastName;

    // person username
    private String username;

    // person password
    private String password;






         /* Constructor */

    public Identity(String name, String lastName, String username, String password)
    {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }










            /*  Methods  */




    // * setter methods *
    
    /**
     * @param name the name to set
     */
    public void setName(String name) { this.name = name; }
    /**
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) { this.lastName = lastName; }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) { this.username = username; }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) { this.password = password; }




    // * getter methods *

    /**
     * @return name
     */
    public String getName() { return name; }
    /**
     * @return last name
     */
    public String getLastName() { return lastName; }
    /**
     * @return username
     */
    public String getUsername() { return username; }



    

    /**
     * This method checks the given password
     * 
     * 
     * @param passwordToCheck : a password to check
     * @return {@code true} if your given password is correct
     * 
     * @see String#equals(Object)
     */
    public boolean isPasswordCorrect(String passwordToCheck)
    {
        return this.password.equals(passwordToCheck);
    }
}
