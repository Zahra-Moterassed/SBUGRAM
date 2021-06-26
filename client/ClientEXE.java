package Client;

import Common.Account;
import Common.Post;

public class ClientEXE {
    public static Account account;
    public static Post post;

    public static Account getProfile(){
        return account;
    }

    public static void setProfile(Account account){
        ClientEXE.account = account;
    }

    public static Post getPost(){
        return post;
    }

    public static void setPost(Post post){
        ClientEXE.post = post;
    }
}
