package com.example.model;

public class coach {
    private String coachid;
    private String name;
    private String gender;
    private String phnum;
    private String age;
    private String goodat;
    private String selfintro;

    private String chargestandard;

    public String getChargestandard() {
        return chargestandard;
    }

    public void setChargestandard(String chargestandard) {
        this.chargestandard = chargestandard;
    }

    public String getCoachid() {
        return coachid;
    }

    public void setCoachid(String coachid) {
        this.coachid = coachid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat;
    }

    public String getSelfintro() {
        return selfintro;
    }

    public void setSelfintro(String selfintro) {
        this.selfintro = selfintro;
    }

    public coach(String coachid, String name, String gender, String phnum, String age, String goodat, String selfintro, String chargestandard) {
        this.coachid = coachid;
        this.name = name;
        this.gender = gender;
        this.phnum = phnum;
        this.age = age;
        this.goodat = goodat;
        this.selfintro = selfintro;
        this.chargestandard = chargestandard;
    }

    public coach() {
    }

    @Override
    public String toString() {
        return "coach{" +
                "coachid='" + coachid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phnum='" + phnum + '\'' +
                ", age='" + age + '\'' +
                ", goodat='" + goodat + '\'' +
                ", selfintro='" + selfintro + '\'' +
                ", chargestandard='" + chargestandard + '\'' +
                '}';
    }
}
