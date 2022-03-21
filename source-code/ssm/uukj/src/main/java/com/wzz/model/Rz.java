package com.wzz.model;

/**
 * @ClassName Rz
 * @Description TODO  日志类
 * @Author wzj
 * Version 1.0
 **/
public class Rz {
    private int id;
    private int userid;
    private String rzname;
    private String rztext;
    private String date1;

    @Override
    public String toString() {
        return "Rz{" +
                "id=" + id +
                ", userid=" + userid +
                ", rzname='" + rzname + '\'' +
                ", rztext='" + rztext + '\'' +
                ", date1='" + date1 + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getRzname() {
        return rzname;
    }

    public void setRzname(String rzname) {
        this.rzname = rzname;
    }

    public String getRztext() {
        return rztext;
    }

    public void setRztext(String rztext) {
        this.rztext = rztext;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
}
