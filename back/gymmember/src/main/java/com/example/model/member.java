package com.example.model;

public class member {
    private String cardnum;
    private String name;
    private String idnum;
    private Float discount;
    private String phnum;
    private String type;
    private Integer allmoney;
    private String status;
    private String comment;

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAllmoney() {
        return allmoney;
    }

    public void setAllmoney(Integer allmoney) {
        this.allmoney = allmoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "member{" +
                "cardnum=" + cardnum +
                ", name='" + name + '\'' +
                ", idnum=" + idnum +
                ", discount=" + discount +
                ", phnum=" + phnum +
                ", type='" + type + '\'' +
                ", allmoney=" + allmoney +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public member() {
    }

    public member(String cardnum, String name, String idnum, Float discount, String phnum, String type, Integer allmoney, String status, String comment) {
        this.cardnum = cardnum;
        this.name = name;
//        this.passwd = passwd;
        this.idnum = idnum;
        this.discount = discount;
        this.phnum = phnum;
        this.type = type;
        this.allmoney = allmoney;
        this.status = status;
        this.comment = comment;
    }
}
