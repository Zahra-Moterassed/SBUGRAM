package Server;

import Common.Commands;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler implements Runnable{
    private Socket Socket;
    private ObjectOutputStream Output;
    private ObjectInputStream Input;
    public Boolean clientOnline = true;

    public ClientHandler(Socket socket){
        try{
            this.Socket = socket;
            this.Input = new ObjectInputStream (this.Socket.getInputStream());
            this.Output = new ObjectOutputStream (this.Socket.getOutputStream());
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (clientOnline){
            Map<String,Object> income=null;
            try{
                income = (Map<String,Object>) Input.readObject();
                Map<String,Object> answer = null;
                Commands command = (Commands) income.get("command");
                switch(command){
                    case UsernameIsUnique:
                        answer = API.isUserNameUnique(income);
                        break;
                    case LogIn:
                        answer=API.login(income);
                        break;
                    case SignUp:
                        answer=API.signUp(income);
                        break;
                    case UPDATE_PROFILE:
                        answer = API.updateProfile(income);
                        break;
                    case LogOut:
                        answer = API.logout(income);
                        clientOnline = false;
                        break;

                }
                Output.writeObject(answer);
                Output.flush();
            }
            catch(ClassCastException | ClassNotFoundException e){
            } catch(IOException e){
                break;
            }
        }
        try{
            Input.close();
            Output.close();
            Socket.close();
        }catch(IOException e){
        }
    }
}
