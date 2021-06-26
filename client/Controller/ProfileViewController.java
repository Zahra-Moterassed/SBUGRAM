package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Post;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProfileViewController {
    public ImageView ProfilePhoto;
    public Text Name;
    public Text Username;
    public Text Birthday;
    public Text Followers;
    public Text Followings;
    public ListView PostsList;


    @FXML
    public void initialize(){
        Name.setText(ClientEXE.getPost().getWriter().firstname+" "+ClientEXE.getPost().getWriter().lastname);
        Username.setText(ClientEXE.getPost().getWriter().AccountUsername);
        Birthday.setText(ClientEXE.getPost().getWriter().DateOfBirth);

        Set<Post> posts= ClientAPI.getPosts();
        List<Post> newPosts=posts.stream().filter(x->x.getWriter().equals(ClientEXE.getPost().getWriter())).
                sorted((a, b)-> (int) (b.getCreatedTime()-a.getCreatedTime())).collect(Collectors.toList());

        //show the post array in list view
        PostsList.setItems(FXCollections.observableArrayList(newPosts));

        //customize each cell of postList with new graphic object PostItem
        PostsList.setCellFactory(postList -> new PostItem());

    }

    public void Follow(ActionEvent actionEvent) {

    }

    public void Unfollow(ActionEvent actionEvent) {

    }

    public void BackToMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Menu");
    }
}
