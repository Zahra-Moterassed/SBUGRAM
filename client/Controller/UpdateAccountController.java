package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Account;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class UpdateAccountController {

    public TextField firstname;
    public TextField lastname;
    public TextField phoneNumber;
    public TextField Birthday;
    public TextField Password;
    public TextField forgetPasseordQ;
    public ImageView ProfilePhoto;

    public void UpdateAccount(ActionEvent actionEvent) throws IOException {
        Account account=new Account(ClientEXE.getProfile().AccountUsername,Password.getText(),firstname.getText(),lastname.getText()
        ,phoneNumber.getText(),Birthday.getText(),forgetPasseordQ.getText());
        if(ClientAPI.updateProfile(account)){
            ClientEXE.setProfile(account);
            new PageLoader().load("YourProfile");
        }
    }

    public Image chooser() {
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showOpenDialog(PageLoader.stage.getScene().getWindow());
        return new Image(file.toURI().toString());
    }

    public void ChoosePhoto(ActionEvent actionEvent) {
        ProfilePhoto.setImage(chooser());
    }
}
