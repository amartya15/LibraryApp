package com.example.libraryapp;



public class userlog  {
    String username,password,location;
    int userid;

    public userlog( int userid,String username, String password,String location) {
        this.username = username;
        this.password = password;
        this.location = location;
        this.userid = userid;
    }
}
