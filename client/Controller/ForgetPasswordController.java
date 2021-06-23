package Client.Controller;

import Client.ClientAPI;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ForgetPasswordController {
    public TextField ForgetPasswordAnswer;
    public TextField Username;
    public TextField RetrievedPassword;

    public void CheckAnswer(ActionEvent actionEvent) {
        String password=ClientAPI.ForgetPassword(Username.getText(), ForgetPasswordAnswer.getText()).AccountPassword;
        RetrievedPassword.setText(password);
        RetrievedPassword.setVisible(true);
    }

    public void BackTOLogin(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("login");
    }
}
