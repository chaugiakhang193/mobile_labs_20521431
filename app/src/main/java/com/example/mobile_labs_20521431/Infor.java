package com.example.mobile_labs_20521431;

public class Infor {
    private String name;
    private int phone;

    public Infor(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }
    public Infor() {
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
