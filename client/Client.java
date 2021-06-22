package Client;

import Client.Model.Main;
import Common.Account;

public class Client {
    public static Account account;

    public static Account getProfile(){
        return account;
    }
    public static void setProfile(Account account){
        Client.account = account;
    }

}
