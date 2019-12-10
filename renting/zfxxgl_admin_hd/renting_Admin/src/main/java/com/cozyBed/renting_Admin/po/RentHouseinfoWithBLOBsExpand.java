package com.cozyBed.renting_Admin.po;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: RentHouseinfoWithBLOBsExpand</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
public class RentHouseinfoWithBLOBsExpand extends RentHouseinfoWithBLOBs {

    private List<String> pic = new ArrayList<String>();

    public Integer rownum;

    private int temp = 0;

    private StringBuffer baseData;

    public void setPic(List<String> pic) {
        this.pic = pic;
    }

    public List<String> getPic() {
        if(temp==0){
            String s = getPicture();
            s = s.substring(s.indexOf("[")+1,s.indexOf("]"));
            String[] j = s.split(",");
            for (int i = 0; i < j.length; i++) {
                pic.add(j[i].trim());
            }
            temp++;
        }
        return pic;
    }

    public void setBaseData(StringBuffer baseData) {
        this.baseData = baseData;
    }

    public StringBuffer getBaseData() {
        return baseData;
    }

    public Integer getRownum() {
        return rownum;
    }

    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }
}
