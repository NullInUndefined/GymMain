package com.example.model;

import java.sql.Timestamp;

public class adminorder {
    private String orderid;
    private String cardnum;
    private Timestamp costtime;
    private Integer costmoney;
    private Integer allmoney;
    private String comment;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public Timestamp getCosttime() {
        return costtime;
    }

    public void setCosttime(Timestamp costtime) {
        this.costtime = costtime;
    }

    public Integer getCostmoney() {
        return costmoney;
    }

    public void setCostmoney(Integer costmoney) {
        this.costmoney = costmoney;
    }

    public Integer getAllmoney() {
        return allmoney;
    }

    public void setAllmoney(Integer allmoney) {
        this.allmoney = allmoney;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "adminorder{" +
                "orderid='" + orderid + '\'' +
                ", cardnum='" + cardnum + '\'' +
                ", costtime=" + costtime +
                ", costmoney=" + costmoney +
                ", allmoney=" + allmoney +
                ", comment='" + comment + '\'' +
                '}';
    }

    public adminorder() {
    }

    public adminorder(String orderid, String cardnum, Timestamp costtime, Integer costmoney, Integer allmoney, String comment) {
        this.orderid = orderid;
        this.cardnum = cardnum;
        this.costtime = costtime;
        this.costmoney = costmoney;
        this.allmoney = allmoney;
        this.comment = comment;
    }
}