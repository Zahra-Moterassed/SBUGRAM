package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Post;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TimeLineController {

    public ListView<Post> postsList;

    public void Menu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Menu");
    }

    @FXML
    public void initialize(){

        Set<Post> posts= ClientAPI.getPosts();
        List<Post> newPosts=posts.stream().filter(x->x.getWriter().equals(ClientEXE.getProfile())).
                sorted((a, b)-> (int) (b.getCreatedTime()-a.getCreatedTime())).collect(Collectors.toList());

        //show the post array in list view
        postsList.setItems(FXCollections.observableArrayList(newPosts));

        //customize each cell of postList with new graphic object PostItem
        postsList.setCellFactory(postList -> new PostItem());
    }


    public void Refresh(ActionEvent actionEvent) throws IOException {
        Set<Post> posts= ClientAPI.getPosts();
        List<Post> newPosts=posts.stream().filter(x->x.getWriter().equals(ClientEXE.getProfile())).
                sorted((a, b)-> (int) (b.getCreatedTime()-a.getCreatedTime())).collect(Collectors.toList());
        postsList.setItems(FXCollections.observableArrayList(newPosts));

        //customize each cell of postList with new graphic object PostItem
        postsList.setCellFactory(postList -> new PostItem());
        new PageLoader().load("timeLine");
    }
}
