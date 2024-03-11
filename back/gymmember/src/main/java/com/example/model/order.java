package com.example.model;

import java.sql.Timestamp;

public class order {
    private String orderid;
    private Timestamp costtime;
    private Integer changemoney;
    private Integer leftmoney;
    private String comment;
    private String staffid;

    public order(String orderid, Timestamp costtime, Integer changemoney, Integer leftmoney, String comment, String staffid) {
        this.orderid = orderid;
        this.costtime = costtime;
        this.changemoney = changemoney;
        this.leftmoney = leftmoney;
        this.comment = comment;
        this.staffid = staffid;
    }

    public order() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Timestamp getCosttime() {
        return costtime;
    }

    public void setCosttime(Timestamp costtime) {
        this.costtime = costtime;
    }

    public Integer getChangemoney() {
        return changemoney;
    }

    public void setChangemoney(Integer changemoney) {
        this.changemoney = changemoney;
    }

    public Integer getLeftmoney() {
        return leftmoney;
    }

    public void setLeftmoney(Integer leftmoney) {
        this.leftmoney = leftmoney;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }
}
