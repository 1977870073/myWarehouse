package com.cozyBed.renting_Admin.po;

import java.io.Serializable;

public class RentHouseinfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer price;

    private String priceType;

    private String houseType;

    private String rentalMode;

    private Integer area;

    private String floor;

    private Integer allfloor;

    private String orientation;

    private String renovation;

    private String residentialAreas;

    private String residentialNote;

    private String district;

    private String user;

    private Integer userType;

    private String userName;

    private String userPhone;

    private Integer flag;

    private String dotime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType == null ? null : priceType.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getRentalMode() {
        return rentalMode;
    }

    public void setRentalMode(String rentalMode) {
        this.rentalMode = rentalMode == null ? null : rentalMode.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public Integer getAllfloor() {
        return allfloor;
    }

    public void setAllfloor(Integer allfloor) {
        this.allfloor = allfloor;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    public String getRenovation() {
        return renovation;
    }

    public void setRenovation(String renovation) {
        this.renovation = renovation == null ? null : renovation.trim();
    }

    public String getResidentialAreas() {
        return residentialAreas;
    }

    public void setResidentialAreas(String residentialAreas) {
        this.residentialAreas = residentialAreas == null ? null : residentialAreas.trim();
    }

    public String getResidentialNote() {
        return residentialNote;
    }

    public void setResidentialNote(String residentialNote) {
        this.residentialNote = residentialNote == null ? null : residentialNote.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
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