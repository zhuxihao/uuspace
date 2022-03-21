package com.wzz.model;
/**
 * @ClassName ss
 * @Description TODO  说说类
 * @Author wzj
 * Version 1.0
 **/
public class ss {

    private int id;
    private int userid;
    private String sstext;
    private String date1;

    @Override
    public String toString() {
        return "ss{" +
                "id=" + id +
                ", userid=" + userid +
                ", sstext='" + sstext + '\'' +
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

    public String getSstext() {
        return sstext;
    }

    public void setSstext(String sstext) {
        this.sstext = sstext;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
}
