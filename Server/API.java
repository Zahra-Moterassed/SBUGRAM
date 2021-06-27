package Server;

import Client.ClientEXE;
import Common.Account;
import Common.Commands;
import Common.Post;
import Common.Time;

import java.util.HashMap;
import java.util.Map;

public class API {
    public static Map<String,Object> isUserNameUnique(Map<String,Object> income){

        String username2check = (String) income.get("username");
        Account account = Server.accounts.get(username2check);
        Boolean exists = (account != null);

        Map<String,Object> ans = new HashMap<>();
        ans.put("answer",exists);
        ans.put("command", Commands.UsernameIsUnique);

        return ans;
    }


    public static Map<String,Object> login(Map<String,Object> income){

        String username = (String) income.get("username");
        String password = (String) income.get("password");

        Boolean isNullAccount = (Server.accounts.get(username) == null);
        Map<String,Object> answer = new HashMap<>();
        answer.put("command",Commands.LogIn);
        answer.put("exists",!isNullAccount);
        if(isNullAccount){
            return answer;
        }
        Account account = Server.accounts.get(username).authenticate(username, password);
        answer.put("answer",account);

        if(account != null){

            System.out.println(account.getUserName() + " signin");
            System.out.println("time : "+ Time.getTime());

        }
        return answer;
    }

    public static Map<String,Object> signUp(Map<String,Object> income){
        Account newAccount = (Account) income.get("account");
        String username = newAccount.getUserName();
        Server.accounts.put(username, newAccount);
        DataBase.getInstance().updateDataBase(); // save to local file
        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Commands.SignUp);
        ans.put("answer",new Boolean(true) );

        System.out.println(newAccount.getUserName() + " register" ); //add image address
        System.out.println("time : "+Time.getTime());
        System.out.println(newAccount.getUserName() + " login");
        System.out.println("time : "+Time.getTime());

        return ans;
    }
    public static Map<String,Object> ForgetPassword(Map<String,Object> income){

        String username = (String) income.get("username");
        String ForgetPassword = (String) income.get("ForgetPasswordAnswer");

        boolean isNullAccount = (Server.accounts.get(username) == null);
        Map<String,Object> answer = new HashMap<>();
        answer.put("command",Commands.FORGET_PASSWORD);
        answer.put("exists",!isNullAccount);
        if(isNullAccount){
            return answer;
        }
        Account account = Server.accounts.get(username).findAccount(username,ForgetPassword);
        answer.put("answer",account);

        return answer;
    }

    public static Map<String,Object> updateProfile(Map<String,Object> income){

        Account newAccount = (Account) income.get("account");
        String username = newAccount.getUserName();
        Server.accounts.replace(username, newAccount);
        DataBase.getInstance().updateDataBase(); // save to local file

        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Commands.UPDATE_PROFILE);
        ans.put("answer",new Boolean(true));

        System.out.println(newAccount.getUserName()+" update info");

        System.out.println("time : "+Time.getTime());

        return ans;
    }

    public static Map<String,Object> logout(Map<String,Object> income){
        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Commands.LogOut);
        ans.put("answer",new Boolean(true));
        System.out.println("logout");
        System.out.println("time : "+Time.getTime());
        return ans;
    }


    public static Map<String, Object> AddPost(Map<String, Object> income) {
        try {
            Map<String, Object> answer = new HashMap<>();
            Post newPost = (Post) income.get("post");
            Server.posts.add(newPost);
            DataBase.getInstance().updateDataBase();
            answer.put("command", Commands.ADD_POST);
            answer.put("answer", new Boolean(true));

            System.out.println(ClientEXE.getProfile().AccountUsername+" publish");
            System.out.println("message: "+newPost.getTitle()+" "+newPost.getWriter().AccountUsername);
            System.out.println("time : "+Time.getTime());
            return answer;
        }catch (Exception e){e.printStackTrace();}
        return null;

    }

    public static Map<String, Object> getPosts(Map<String, Object> income) {
        Map<String,Object> answer = new HashMap<>();
        answer.put("command",Commands.GET_POSTS);
        answer.put("answer",Server.posts);

        System.out.println(" get posts list");
        System.out.println("time : "+Time.getTime());
        return answer;

    }

    public static Map<String, Object> LikePost(Map<String, Object> income) {
        Map<String,Object> answer = new HashMap<>();
        Post newPost = (Post) income.get("post");
        Server.posts.remove(newPost);
        Server.posts.add(newPost);

        DataBase.getInstance().updateDataBase(); // save to local file

        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Commands.LIKE_POST);
        ans.put("answer",new Boolean(true));

        System.out.println(newPost.getWriter().AccountUsername+" like");
        System.out.println("message: "+newPost.getWriter().AccountUsername+" "+newPost.getTitle());
        System.out.println("time : "+Time.getTime());
        return ans;

    }
}
