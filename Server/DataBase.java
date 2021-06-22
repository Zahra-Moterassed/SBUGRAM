package Server;

import Common.Account;
import Common.Post;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class DataBase {

    public static final String FILE_PREFIX ="C:\\Users\\Moterased\\IdeaProjects\\SBUGRAM\\Data\\";
    public static final String ACCOUNTS_FILE = FILE_PREFIX + "AccountsDB.txt";
    public static final String POSTS_FILE =FILE_PREFIX +"PostsDB.txt";


    private static DataBase ourInstance = new DataBase();

    public static DataBase getInstance() {
        return ourInstance;
    }
    private DataBase() {}

    public synchronized void initializeServer(){
        try {
            FileInputStream FileIn =new FileInputStream(DataBase.ACCOUNTS_FILE);
            ObjectInputStream inFromFile=new ObjectInputStream(FileIn);
            Server.accounts = new ConcurrentHashMap<>( (ConcurrentHashMap<String, Account>) inFromFile.readObject());
            inFromFile.close();
            FileIn.close();
        }
        catch(EOFException | StreamCorruptedException e){
            Server.accounts = new ConcurrentHashMap<>();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            FileInputStream fin = new FileInputStream(DataBase.POSTS_FILE);
            ObjectInputStream inFromFile = new ObjectInputStream(fin);
            Server.posts = new ConcurrentSkipListSet<>( (ConcurrentSkipListSet<Post>) inFromFile.readObject());
            inFromFile.close();
            fin.close();
        }
        catch(EOFException | StreamCorruptedException e){
            Server.posts = new ConcurrentSkipListSet<>();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public synchronized void updateDataBase(){
        try {
            FileOutputStream FileOut = new FileOutputStream(ACCOUNTS_FILE);
            ObjectOutputStream objToFile = new ObjectOutputStream(FileOut);
            objToFile.writeObject(Server.accounts);
            objToFile.close();
            FileOut.close();

            FileOut=new FileOutputStream(POSTS_FILE);
            objToFile=new ObjectOutputStream(FileOut);
            objToFile.writeObject(Server.posts);
            objToFile.close();
            FileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
