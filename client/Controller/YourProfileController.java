package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Account;
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

public class YourProfileController {
    public ImageView YourProfilePhoto;
    public Text Name;
    public Text Username;
    public Text NumberOfFollowers;
    public Text NumberOfFollowings;
    public Text Birthday;
    public ListView YourPosts;
    Account account= ClientEXE.getProfile();

    @FXML
    public void initialize(){
        Name.setText(account.firstname+" "+account.lastname);
        Username.setText(account.AccountUsername);
        Birthday.setText(account.DateOfBirth);

        Set<Post> posts= ClientAPI.getPosts();
        List<Post> newPosts=posts.stream().filter(x->x.getWriter().equals(ClientEXE.getProfile())).
                sorted((a, b)-> (int) (b.getCreatedTime()-a.getCreatedTime())).collect(Collectors.toList());

        //show the post array in list view
        YourPosts.setItems(FXCollections.observableArrayList(newPosts));

        //customize each cell of postList with new graphic object PostItem
        YourPosts.setCellFactory(postList -> new PostItem());

    }

    public void UpdateInfo(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("UpdateAccount");
    }

    public void BackToMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("Menu");
    }
}
