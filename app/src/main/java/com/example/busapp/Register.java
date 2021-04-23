package com.example.busapp;

public class Register {
    String pessangerno;
    String fullname;
    String phone;
    String user;
    String password;
    String bus;


    public Register()
    {


    }


    public Register(String pessangerno,String fullname, String phone, String user, String password, String bus) {
        this.pessangerno=pessangerno;
        this.fullname = fullname;
        this.phone = phone;
        this.user = user;
        this.password = password;
        this.bus = bus;
    }

    public String getPessangerno() {
        return pessangerno;
    }

    public void setPessangerno(String pessangerno) {
        this.pessangerno = pessangerno;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }
}
