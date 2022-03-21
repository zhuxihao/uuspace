package com.wzz.model;

/**
 * @ClassName Ly
 * @Description TODO  留言类
 * @Author wzj
 * Version 1.0
 **/

public class Ly {

    private int id;
    private int userid;
    private String Lytext;
    private String Lydate;

    @Override
    public String toString() {
        return "Ly{" +
                "id=" + id +
                ", userid=" + userid +
                ", Lytext='" + Lytext + '\'' +
                ", Lydate='" + Lydate + '\'' +
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

    public String getLytext() {
        return Lytext;
    }

    public void setLytext(String lytext) {
        Lytext = lytext;
    }

    public String getLydate() {
        return Lydate;
    }

    public void setLydate(String lydate) {
        Lydate = lydate;
    }
}
