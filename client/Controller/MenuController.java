package Client.Controller;

import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuController {
    public void Profile(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("YourProfile");
    }

    public void NewPost(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("NewPost");
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("login");
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        new PageLoader().load("timeLine");
    }
}
