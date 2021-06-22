package Common;

import java.io.Serializable;

public class Account implements Serializable {

    public String AccountUsername;
    public String AccountPassword;
    public String firstname;
    public String lastname;
    public String phoneNumber;
    public String DateOfBirth;

    public Account(String accountUsername, String accountPassword, String firstname, String lastname,
                   String phoneNumber, String dateOfBirth) {
        AccountUsername = accountUsername;
        AccountPassword = accountPassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        DateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return AccountUsername;
    }
    @Override
    public int hashCode() {
        return AccountUsername.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        try{
            return this.AccountUsername.equals(((Account)obj).getUserName());
        }
        catch(Exception e){
            return false;
        }
    }
    public Account authenticate(String username,String password){
        if(this.AccountUsername.equals(username) && this.AccountPassword.equals(password)) return this;
        return null;
    }


}
