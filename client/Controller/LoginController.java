package Client.Controller;

import Client.ClientAPI;
import Common.Account;
import Client.Model.PageLoader;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController {
    @FXML
    public PasswordField password_field;
    public javafx.scene.control.Button login_button;
    public TextField username_field;
    public Button signup_button;
    public Label wrongPass_label;
    public TextField Password_textfield;

    public boolean isCorrectUserPass(String password,String username){
        return ClientAPI.login(username, password) != null;
    }

    public void login(ActionEvent actionEvent) throws IOException {
        String username=username_field.getText();
        String password;
        if (password_field.isVisible()) {
            password = password_field.getText();
        }
        else{
            password=Password_textfield.getText();
        }

        if(isCorrectUserPass(password,username)){
            wrongPass_label.setVisible(false);
           new PageLoader().load("timeLine");
        }
        else{
            wrongPass_label.setVisible(true);
        }

    }
    @FXML
    public void initialize(){
        TranslateTransition signuptrasition=new TranslateTransition(Duration.millis(2000),signup_button);
        signuptrasition.setToY(-167);
        signuptrasition.playFromStart();
    }

    public void signup(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("SignUp");
    }

    public void showPassword(ActionEvent actionEvent) {
        if (!Password_textfield.isVisible()){
            Password_textfield.setVisible(true);
            password_field.setVisible(false);
            Password_textfield.setText(password_field.getText());
        }
        else{
            Password_textfield.setVisible(false);
            password_field.setVisible(true);
            password_field.setText(Password_textfield.getText());
        }
    }

    public void RetrievePassword(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("ForgetPassword");
    }
}
