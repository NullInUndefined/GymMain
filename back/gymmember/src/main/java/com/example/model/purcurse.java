package com.example.model;

import java.sql.Timestamp;

public class purcurse {
    private String orderid;
    private String cardnum;
    private String curseid;
    private Timestamp costtime;
    private String comment;
    private Integer costmoney;

    public purcurse(String orderid, String cardnum, String curseid, Timestamp costtime, String comment, Integer costmoney) {
        this.orderid = orderid;
        this.cardnum = cardnum;
        this.curseid = curseid;
        this.costtime = costtime;
        this.comment = comment;
        this.costmoney = costmoney;
    }

    public purcurse() {
    }

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

    public String getCurseid() {
        return curseid;
    }

    public void setCurseid(String curseid) {
        this.curseid = curseid;
    }

    public Timestamp getCosttime() {
        return costtime;
    }

    public void setCosttime(Timestamp costtime) {
        this.costtime = costtime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCostmoney() {
        return costmoney;
    }

    public void setCostmoney(Integer costmoney) {
        this.costmoney = costmoney;
    }

    @Override
    public String toString() {
        return "purcurse{" +
                "orderid='" + orderid + '\'' +
                ", cardnum='" + cardnum + '\'' +
                ", curseid='" + curseid + '\'' +
                ", costtime=" + costtime +
                ", comment='" + comment + '\'' +
                ", costmoney=" + costmoney +
                '}';
    }
}
