




/**
 * This class represent register page's controller
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.2
 */
public class RegisterController
{

            /*  Fields  */
    
    // register page's view
    RegisterView registerView;








         /* Constructor */

    /**
     * create register page's controller
     */
    public RegisterController() 
    {
        registerView = new RegisterView();
    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return register page's view
     */
    public RegisterView getRegisterView() { return registerView; }
}
