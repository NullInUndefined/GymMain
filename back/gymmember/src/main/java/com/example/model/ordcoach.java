package com.example.model;

import java.sql.Timestamp;

public class ordcoach {

    private String orderid;
    private String cardnum;
    private String coachid;
    private Timestamp costtime;
    private String comment;
    private Integer costmoney;

    public ordcoach(String orderid, String cardnum, String coachid, Timestamp costtime, String comment, Integer costmoney) {
        this.orderid = orderid;
        this.cardnum = cardnum;
        this.coachid = coachid;
        this.costtime = costtime;
        this.comment = comment;
        this.costmoney = costmoney;
    }

    public ordcoach() {
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

    public String getCoachid() {
        return coachid;
    }

    public void setCoachid(String coachid) {
        this.coachid = coachid;
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
        return "ordcoach{" +
                "orderid='" + orderid + '\'' +
                ", cardnum='" + cardnum + '\'' +
                ", coachid='" + coachid + '\'' +
                ", costtime=" + costtime +
                ", comment='" + comment + '\'' +
                ", costmoney=" + costmoney +
                '}';
    }
}
