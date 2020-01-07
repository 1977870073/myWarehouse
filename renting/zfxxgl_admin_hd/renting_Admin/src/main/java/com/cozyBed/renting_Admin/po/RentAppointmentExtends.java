package com.cozyBed.renting_Admin.po;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.po
 * @ClassName: RentAppointmentExtends
 * @Description: 预约房源消息显示
 * @Author: zy
 * @CreateDate: 2020/1/5 15:46
 * @Version: 1.0
 */
public class RentAppointmentExtends extends RentAppointment {
    private String title;

    private String userName;

    private Integer rownum;

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
