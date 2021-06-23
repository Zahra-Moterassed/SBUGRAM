package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Account;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UpdateAccountController {

    public TextField firstname;
    public TextField lastname;
    public TextField phoneNumber;
    public TextField Birthday;
    public TextField Password;
    public TextField forgetPasseordQ;

    public void UpdateAccount(ActionEvent actionEvent) throws IOException {
        Account account=new Account(ClientEXE.getProfile().AccountUsername,Password.getText(),firstname.getText(),lastname.getText()
        ,phoneNumber.getText(),Birthday.getText(),forgetPasseordQ.getText());
        if(ClientAPI.updateProfile(account)){
            ClientEXE.setProfile(account);
            new PageLoader().load("YourProfile");
        }
    }

    public void ChoosePhoto(ActionEvent actionEvent) {

    }
}
