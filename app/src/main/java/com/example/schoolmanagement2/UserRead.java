package com.example.schoolmanagement2;

public class UserRead {
    String fullName;
    String userName;
    String email;
    String pass;
    String gender;

    public UserRead() {
    }

    public UserRead(String fullName, String userName, String email, String pass, String gender) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.pass = pass;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
