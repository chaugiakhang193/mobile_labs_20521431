package com.example.mobile_labs_20521431;

public class User {
    private String FullName;
    private String Phone;
    private String UserName;
    private String Password;

    public User(String Fullname, String Phone, String UserName , String Password ) {
        this.FullName = Fullname;
        this.Phone = Phone;
        this.UserName = UserName;
        this.Password = Password;
    }
    public User() {
    }

    public String getFullName() {
        return FullName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
