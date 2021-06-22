package Client.Controller;

import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class ProfileViewController {
    public ImageView ProfilePhoto;
    public Text Name;
    public Text Username;
    public Text BirthDay;
    public Text Followers;
    public Text Followings;

    public void Follow(ActionEvent actionEvent) {

    }

    public void Unfollow(ActionEvent actionEvent) {

    }

    public void BackToMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Menu");
    }
}
