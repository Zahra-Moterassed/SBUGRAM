package Client.Controller;

import Client.ClientAPI;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class ForgetPasswordController {
    public TextField ForgetPasswordAnswer;
    public TextField Username;
    public TextField RetrievedPassword;
    public Text yourPasswordIs;

    public void CheckAnswer(ActionEvent actionEvent) {
        String password=ClientAPI.ForgetPassword(Username.getText(), ForgetPasswordAnswer.getText()).AccountPassword;
        RetrievedPassword.setText(password);
        yourPasswordIs.setVisible(true);
        RetrievedPassword.setVisible(true);
    }

    public void BackTOLogin(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("login");
    }
}
