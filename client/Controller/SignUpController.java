package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Common.Account;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.*;

public class SignUpController extends Component {
    public TextField name;
    public TextField Lastname;
    public TextField BirthDate;
    public TextField Username;
    public TextField password;
    public TextField PhoneNumber;
    public Text username_already;
    public Text invalid_password;
    public ImageView profile;
    public TextField ForgetPasswordQ;
    Account account;
    public void BackToLogin(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("login");
    }

    public boolean isValidPassword(String password){
        if (password.length()<8)
            return false;
        return true;
    }

    public boolean isValidUsername(String username){
        return !ClientAPI.isUserNameExists(username);
    }

    public void SignUp(ActionEvent actionEvent) throws IOException {
            if (!isValidPassword(password.getText())) {
                invalid_password.setVisible(true);
            }
            if (!isValidUsername(Username.getText())) {
                username_already.setVisible(true);
            }
            if (isValidUsername(Username.getText()) && isValidPassword(password.getText())) {
                invalid_password.setVisible(false);
                username_already.setVisible(false);
                account = new Account(Username.getText(), password.getText(), name.getText(), Lastname.getText()
                        , PhoneNumber.getText(), BirthDate.getText(),ForgetPasswordQ.getText());

                ClientEXE.setProfile(account);
               if (ClientAPI.signUp(account)) {
                   new PageLoader().load("timeLine");
               }
            }
    }

    public Image chooser() throws IOException {
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showOpenDialog(PageLoader.stage.getScene().getWindow());
        return new Image(file.toURI().toString());
    }

    public void ChoosePhoto(ActionEvent actionEvent) throws IOException {
        profile.setImage(chooser());
    }
}