package Common;

import java.io.Serializable;

public class Account implements Serializable {

    public String AccountUsername;
    public String AccountPassword;
    public String firstname;
    public String lastname;
    public String phoneNumber;
    public String DateOfBirth;
    public String ForgetPasswordAnswer;

    public Account(String accountUsername, String accountPassword, String firstname, String lastname,
                   String phoneNumber, String dateOfBirth,String ForgetPasswordAnswer) {
        AccountUsername = accountUsername;
        AccountPassword = accountPassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        DateOfBirth = dateOfBirth;
        this.ForgetPasswordAnswer=ForgetPasswordAnswer;
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
    public Account findAccount(String username,String ForgetPassword){
        if(this.AccountUsername.equals(username) && this.ForgetPasswordAnswer.equals(ForgetPassword)) return this;
        return null;
    }


}
