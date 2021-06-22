package Client.Controller;

import Client.Model.PageLoader;
import Common.Post;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class TimeLineController {

    public ListView<String> postsList;
    public ArrayList<Post> posts=new ArrayList<>();
    public Post currentPost=new Post();

    public void Menu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Menu");
    }
    public void addPost(String title,String description){
        currentPost.setDescription(description);
        currentPost.setTitle(title);
        currentPost.setWriter("nn");
        posts.add(currentPost);
        postsList.getItems().add(currentPost.getTitle());
        currentPost=new Post();
    }
}
