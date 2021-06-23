package Client;

import Common.Account;

public class ClientEXE {
    public static Account account;

    public static Account getProfile(){
        return account;
    }
    public static void setProfile(Account account){
        ClientEXE.account = account;
    }

}
