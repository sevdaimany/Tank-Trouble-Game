import javafx.stage.Stage;


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
   private  RegisterView registerView;

   private Stage stage;









         /* Constructor */

    /**
     * create register page's controller
     */
    public RegisterController() 
    {
        registerView = new RegisterView();
        this.stage =StageConnection.getStage();

    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return register page's view
     */
    public RegisterView getRegisterView() { return registerView; }
}
