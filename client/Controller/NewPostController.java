package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Post;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewPostController {
    public TextArea Description;
    public TextField Title;

    public void Publish(ActionEvent actionEvent) throws IOException {
        String title=Title.getText();
        String description=Description.getText();
        Post post=new Post();
        post.setDescription(description);
        post.setTitle(title);
        post.setWriter(ClientEXE.getProfile());

        if (ClientAPI.AddPost(post)) {
            new PageLoader().load("timeLine");
        }

    }

    public void Back(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
    }
}
