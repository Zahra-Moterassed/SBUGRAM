package Client.Controller;

import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewPostController {

    public TextField Title;
    public TextArea Description;


    public void Publish(ActionEvent actionEvent) throws IOException {
        String title=Title.getText();
        String description=Description.getText();
        TimeLineController t=new TimeLineController();
        t.addPost(title,description);
        Title.setText("");
        Description.setText("");
        new PageLoader().load("timeLine");
    }

    public void Back(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
    }
}
