package com.example.explorekarachi;

public class UserData
{
    String username;
    String password;
    String email;
    String number;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    void setdata(String n, String p , String e , String num)
    {
        this.email = e;
        this.number = num;
        this.password = p;
        this.username = n;
    }
}
