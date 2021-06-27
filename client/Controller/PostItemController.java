package Client.Controller;

import Client.ClientAPI;
import Client.ClientEXE;
import Client.Model.PageLoader;
import Common.Post;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class PostItemController {
    public AnchorPane root;
    public ImageView profileImage;
    public Label Writer;
    public Label title;
    public Label description;
    public Label time;
    public Label reposts;
    public Label likes;
    Post post;

    public PostItemController(Post post) throws IOException {
        new PageLoader().load("postItem", this);
        this.post = post;
    }

    public AnchorPane init() {
        Writer.setText(post.getWriter().AccountUsername);
        title.setText(post.getTitle());
        time.setText(post.getTimeString());
        description.setText(post.getDescription());
        //set another image dynamically
        /*
        if (post.getWriter().equals("ali alavi"))
            profileImage.setImage(new Image(Paths.get("images/ali_alavi.jpg").toUri().toString()));

         */
        return root;
    }

    //you can show post's detail in new page with this method
    public void ViewProfile(ActionEvent actionEvent) throws IOException {
        ClientEXE.setPost(post);
        new PageLoader().load("ProfileView");

    }

    public void Like(MouseEvent mouseEvent){
        AtomicInteger like=new AtomicInteger();
        like.set(post.getLikes().incrementAndGet());
        post.setLikes(like);
        ClientEXE.setProfile(post.getWriter());
       if (ClientAPI.LikePost(post)){
           likes.setText(String.valueOf(post.getLikes()));
       }

    }
    public void Repost(MouseEvent mouseEvent){

    }
    public void Comment(MouseEvent mouseEvent){

    }
}
