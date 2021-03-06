package cn.itcast.ssm.po;

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
}
