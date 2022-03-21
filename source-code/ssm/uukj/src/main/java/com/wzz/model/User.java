package com.wzz.model;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO  用户类
 * @Author wzj
 * Version 1.0
 **/
public class User implements Serializable {
    private Integer id;//key
    private String userName;   //用户名
    private String password;    //密码
    private String uName;      //姓名
    private String sex;    //性别
    private String age;
    private String job;
    private String txurl;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", uName='" + uName + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", job='" + job + '\'' +
                ", txurl='" + txurl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTxurl() {
        return txurl;
    }

    public void setTxurl(String txurl) {
        this.txurl = txurl;
    }
}
