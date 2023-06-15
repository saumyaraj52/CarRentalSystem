package main;

public class User {
    static int uid;
    String username;
    String password;

    public User(String username,String password) {
        this.username = username;
        this.password = password;
        this.uid++;
    }

}
