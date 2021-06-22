package Server;

import Common.Account;
import Common.Commands;
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
            //not mine
            System.out.println(account.getUserName() + " signin");
            System.out.println("time : "+ Time.getTime());
            //not mine
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
        System.out.println(newAccount.getUserName() + " signin");
        System.out.println("time : "+Time.getTime());


        return ans;
    }
//shouldcheck
    public static Map<String,Object> updateProfile(Map<String,Object> income){

        Account newAccount = (Account) income.get("account");
        String username = newAccount.getUserName();
        Server.accounts.replace(username, newAccount);
        DataBase.getInstance().updateDataBase(); // save to local file

        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Commands.UPDATE_PROFILE);
        ans.put("answer",new Boolean(true));
        return ans;
    }

    public static Map<String,Object> logout(Map<String,Object> income){
        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Commands.LogOut);
        ans.put("answer",new Boolean(true));
        return ans;
    }
//shouldcheck

}
