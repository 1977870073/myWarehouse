package com.cozyBed.renting_Admin.po;

public class UserCollection {
    private Integer id;

    private String user;

    private Integer house;

    private Integer flag;

    private String dotime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDotime() {
        return dotime;
    }

    public void setDotime(String dotime) {
        this.dotime = dotime == null ? null : dotime.trim();
    }
}