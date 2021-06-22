package Client.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Paths;

public class PageLoader {
    public static final int WIDTH=400;
    public static final int HEIGHT=600;

    public static Stage stage;
    public static Scene scene;

    public static void initStage(Stage primaryStage){
        stage=primaryStage;
        stage.setTitle("SBUGRAM");
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Paths.get("C:\\Users\\Moterased\\IdeaProjects\\SBUGRAM\\src\\images\\87390.png").toUri().toString()));
    }


    public Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Client/View/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    //load fxmls with already set controllers
    public void load(String url) throws IOException {
        scene = new Scene(new PageLoader().loadFXML(url));
        stage.setScene(scene);
        stage.show();
    }



}
