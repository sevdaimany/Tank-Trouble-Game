import java.io.IOException;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class represent register page's controller
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.2
 */
public class RegisterController {

    /* Fields */

    // register page's view
    private RegisterView registerView;

    private Stage stage;

    /* Constructor */

    /**
     * create register page's controller
     */
    public RegisterController() {
        registerView = new RegisterView();
        this.stage = Main.getStage();
        registerAction();

    }

    /* Methods */

    /**
     * this method sets register button's action listener
     */
    public void registerAction() {
        registerView.getRegisterBTN().setOnAction(event -> {

            try {
                DataBase dataBase = new DataBase();
                String name = registerView.getFirstname().getText();
                String lastname = registerView.getLastname().getText();
                String username = registerView.getUsername().getText();
                String password = registerView.getPassword().getText();
                String repeatPassword = registerView.getRepeatPassword().getText();
                System.out.println(name);
                System.out.println(lastname);
                System.out.println(username);
                System.out.println(password);
                System.out.println(repeatPassword);
                if (name != null && lastname != null && username != null && password != null
                        && repeatPassword != null) {
                    if (!dataBase.isRegistered(username)) {
                        if (password.equals(repeatPassword)) {
                            Player player = new Player(name, lastname, username, password);
                            dataBase.savePlayer(player);
                            MenuController menuController = new MenuController();
                            stage.setScene(new Scene(menuController.getMenuview()));
                            stage.setTitle("Tank Trouble");
                        } else {
                            registerView.getErrorLable().setText("The two password fields didn’t match.");
                        }

                    } else {
                        registerView.getErrorLable().setText("A user with that username already exists.");
                    }
                } else {
                    registerView.getErrorLable().setText("Please fill out fields");
                }
            } catch (IOException e) {
            }

        });
    }

    // * getter methods *

    /**
     * @return register page's view
     */
    public RegisterView getRegisterView() {
        return registerView;
    }
}
