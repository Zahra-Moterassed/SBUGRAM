package Client;

import Common.Account;
import Common.Commands;

import java.util.HashMap;
import java.util.Map;

public class ClientAPI {

    public static boolean isUserNameExists(String username2check){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Commands.UsernameIsUnique);
        toSend.put("username",username2check);
        Map<String, Object> received = ClientConnector.serve(toSend);
        return (boolean) received.get("answer");
    }

    public static Account login(String username, String password){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Commands.LogIn);
        toSend.put("username",username);
        toSend.put("password",password);
        Map<String,Object> received = ClientConnector.serve(toSend);
        if ( received.get("answer") == null ) return null;
        return (Account) received.get("answer");
    }

    public static Boolean signUp(Account account){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Commands.SignUp);
        toSend.put("account", account);
        Map<String,Object> received = ClientConnector.serve(toSend);
        if ( received.get("answer") == null ) return null;
        return (Boolean) received.get("answer");
    }


    public static Account ForgetPassword(String username, String ForgetPasswordAns){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Commands.FORGET_PASSWORD);
        toSend.put("username",username);
        toSend.put("ForgetPasswordAnswer",ForgetPasswordAns);
        Map<String,Object> received = ClientConnector.serve(toSend);
        if ( received.get("answer") == null ) return null;
        return (Account) received.get("answer");
    }



    public static Boolean updateProfile(Account account){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Commands.UPDATE_PROFILE);
        toSend.put("account", account);
        Map<String,Object> recieved = ClientConnector.serve(toSend);
        if ( recieved.get("answer") == null ) return false;
        return (Boolean) recieved.get("answer");
    }


    public static Boolean logout(){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Commands.LogOut);
        Map<String,Object> recieved = ClientConnector.serve(toSend);
        if ( recieved.get("answer") == null ) return false;
        return (Boolean) recieved.get("answer");
    }

}
