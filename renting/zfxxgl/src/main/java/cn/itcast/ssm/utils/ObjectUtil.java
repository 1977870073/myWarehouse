package cn.itcast.ssm.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.utils
 * @ClassName: ObjectUtil
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2019/11/30 20:58
 * @Version: 1.0
 */
public class ObjectUtil {
    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmply(Object obj){
        if(obj!=null){
            if(obj instanceof  String){//字符串类型
                if(obj==null || obj=="" || obj=="null"){
                    return true;
                }
            }else if(obj instanceof Map){
                if(obj==null || ((Map)obj).size()<=0){
                    return true;
                }
            }else if(obj instanceof Collection){
                if(obj==null || ((Collection)obj).size()<=0){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
