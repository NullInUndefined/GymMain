package com.example.model;

public class user {
    private String account;
    private String passwd;
    private String type;

    public user(String account, String passwd, String type) {
        this.account = account;
        this.passwd = passwd;
        this.type = type;
    }

    public user() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "user{" +
                "account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
