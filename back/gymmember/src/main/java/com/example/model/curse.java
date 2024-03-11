package com.example.model;

public class curse {
    private String curseid;
    private String name;
    private String intro;
    private String chargestandard;
    private Integer maxnum;
    private String starttime;
    private Integer leftcurse;

    public curse(String curseid, String name, String intro, String chargestandard, Integer maxnum, String starttime, Integer leftcurse) {
        this.curseid = curseid;
        this.name = name;
        this.intro = intro;
        this.chargestandard = chargestandard;
        this.maxnum = maxnum;
        this.starttime = starttime;
        this.leftcurse = leftcurse;
    }

    public curse() {
    }

    public String getCurseid() {
        return curseid;
    }

    public void setCurseid(String curseid) {
        this.curseid = curseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getChargestandard() {
        return chargestandard;
    }

    public void setChargestandard(String chargestandard) {
        this.chargestandard = chargestandard;
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public Integer getLeftcurse() {
        return leftcurse;
    }

    public void setLeftcurse(Integer leftcurse) {
        this.leftcurse = leftcurse;
    }

    @Override
    public String toString() {
        return "curse{" +
                "curseid=" + curseid +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", chargestandard='" + chargestandard + '\'' +
                ", maxnum=" + maxnum +
                ", starttime='" + starttime + '\'' +
                ", leftcurse=" + leftcurse +
                '}';
    }
}
