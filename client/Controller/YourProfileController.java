package Client.Controller;

import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class YourProfileController {
    public ImageView YourProfilePhoto;
    public Text Name;
    public Text Username;
    public Text BirthDay;
    public Text NumberOfFollowers;
    public Text NumberOfFollowings;

    public void UpdateInfo(ActionEvent actionEvent) {

    }

    public void BackToMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Menu");
    }
}
