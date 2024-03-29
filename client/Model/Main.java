package Client.Model;

import Client.ClientConnector;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        ClientConnector.connectToServer();
        PageLoader.initStage(primaryStage);
        new PageLoader().load("login");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
