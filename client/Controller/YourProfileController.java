package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class YourProfileController {
    public ImageView YourProfilePhoto;
    public Text Name;
    public Text Username;
    public Text NumberOfFollowers;
    public Text NumberOfFollowings;
    public Text Birthday;
    Account account= ClientEXE.getProfile();

    @FXML
    public void initialize(){
        Name.setText(account.firstname+" "+account.lastname);
        Username.setText(account.AccountUsername);
        Birthday.setText(account.DateOfBirth);

    }

    public void UpdateInfo(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("UpdateAccount");
    }

    public void BackToMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Menu");
    }
}
