package com.example.model;

public class venue {
    Integer roomid;
    Integer area;
    String note;
    String courseid;
    String name;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public venue() {
    }

    public venue(Integer roomid, Integer area, String note, String courseid, String name) {
        this.roomid = roomid;
        this.area = area;
        this.note = note;
        this.courseid = courseid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "venue{" +
                "roomid=" + roomid +
                ", area=" + area +
                ", note='" + note + '\'' +
                ", courseid='" + courseid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
