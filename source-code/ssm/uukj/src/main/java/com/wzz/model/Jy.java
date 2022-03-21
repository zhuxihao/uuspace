package com.wzz.model;

/**
 * @ClassName Jy
 * @Description TODO  敬语类
 * @Author wzj
 * Version 1.0
 **/

public class Jy {

    private int id;
    private String Jytext;

    @Override
    public String toString() {
        return "Jy{" +
                "id=" + id +
                ", Jytext='" + Jytext + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJytext() {
        return Jytext;
    }

    public void setJytext(String jytext) {
        Jytext = jytext;
    }
}
