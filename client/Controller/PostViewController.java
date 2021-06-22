package Client.Controller;

import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class PostViewController {
    public Text Likes;
    public Text Reposts;
    public TextField Tile;
    public TextArea Description;
    public Text WriterName;
    public Text PostDate;
    public ImageView ProfilePhoto;

    public void BackToFeed(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
    }

    public void ViewProfile(ActionEvent actionEvent) {
    }

    public void AddComment(ActionEvent actionEvent) {

    }

    public void ViewComments(ActionEvent actionEvent) {
    }

    public void Repost(ActionEvent actionEvent) {
    }

    public void AddLike(ActionEvent actionEvent) {
    }
}
